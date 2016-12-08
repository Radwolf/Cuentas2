package org.rul.repository.datasource;

import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.providers.RealmProvider;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaDbDatasourceImpl implements CuentaDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public CuentaDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public List<CuentaDb> findAll() {
        return getRealm().where(CuentaDb.class).findAll();
    }

    @Override
    public List<CuentaDb> insertAll(List<CuentaDb> elementList) throws RepositoryException {
        getRealm().beginTransaction();
        List<CuentaDb> returnedCuentasDb = null;

        try {
            returnedCuentasDb = getRealm().copyToRealm(elementList);
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return returnedCuentasDb;
    }

    @Override
    public void remove(CuentaDb element) {
        getRealm().beginTransaction();
        RealmQuery<CuentaDb> realmQuery = getRealm().where(CuentaDb.class).equalTo(CuentaDb.K_CUENTA_NOMBRE, element.getNombre());
        RealmResults<CuentaDb> realmResults = realmQuery.findAll();
        realmResults.deleteAllFromRealm();
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public void removeAll() {
        getRealm().beginTransaction();
        getRealm().delete(CuentaDb.class);
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public CuentaDb findByNombre(String nombre) {
        return getRealm().where(CuentaDb.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public CuentaDb insert(final CuentaDb cuenta) throws RepositoryException {
        getRealm().beginTransaction();
        CuentaDb cuentaDb = null;
        try{
            cuentaDb = getRealm().createObject(CuentaDb.class, cuenta.getNombre());
            cuentaDb.setSaldo(cuenta.getSaldo());
            cuentaDb.setFechaActualizacion(Calendar.getInstance().getTime());
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return cuentaDb;
    }

    @Override
    public void updateSaldo(CuentaDb cuenta) {
        getRealm().insertOrUpdate(cuenta);
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }
}
