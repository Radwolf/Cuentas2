package org.rul.repository.datasource;

import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.model.CuentaDb;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaDbDatasourceImpl implements CuentaDbDatasource{

    @Override
    public RealmResults<CuentaDb> findAll() {
        return Realm.getDefaultInstance().where(CuentaDb.class).findAll();
    }

    @Override
    public List<CuentaDb> insertAll(List<CuentaDb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CuentaDb element) {
    }

    @Override
    public void removeAll() {}

    @Override
    public CuentaDb findByNombre(String nombre) {
        return Realm.getDefaultInstance().where(CuentaDb.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public CuentaDb insert(final CuentaDb cuenta) {
        Realm realm = Realm.getDefaultInstance();
        final CuentaDb[] cuentas = {null};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                cuentas[0] = realm.createObject(CuentaDb.class, cuenta.getNombre());
            }
        });
        realm.close();
        return cuentas[0];
    }

    @Override
    public void updateSaldo(CuentaDb cuenta) {
        Realm.getDefaultInstance().insertOrUpdate(cuenta);
    }

    @Override
    public void deleteCuenta(String nombre) {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<CuentaDb> cuentas = realm.where(CuentaDb.class).equalTo("nombre", nombre).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                cuentas.deleteAllFromRealm(); // indirectly delete object
            }
        });
        realm.close();
    }
}
