package org.rul.repository.datasource;

import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.providers.RealmProvider;

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
        RealmResults<CuentaDb> cuentasDbs = getRealm().where(CuentaDb.class).findAll();

        return cuentasDbs;
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
    public CuentaDb insert(final CuentaDb cuenta) {
        final CuentaDb[] cuentas = {null};
        getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                cuentas[0] = realm.createObject(CuentaDb.class, cuenta.getNombre());
            }
        });
        getRealm().close();
        return cuentas[0];
    }

    @Override
    public void updateSaldo(CuentaDb cuenta) {
        Realm.getDefaultInstance().insertOrUpdate(cuenta);
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }
}
