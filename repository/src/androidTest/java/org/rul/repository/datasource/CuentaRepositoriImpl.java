package org.rul.repository.datasource;

import org.rul.cuentas.model.Cuenta;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaRepositoriImpl implements CuentaRepository{

    @Override
    public RealmResults<Cuenta> findAll() {
        return Realm.getDefaultInstance().where(Cuenta.class).findAll();
    }

    @Override
    public List<Cuenta> insertAll(List<Cuenta> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(Cuenta element) {}

    @Override
    public void removeAll() {}

    @Override
    public Cuenta findByNombre(String nombre) {
        return Realm.getDefaultInstance().where(Cuenta.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public Cuenta insert(final Cuenta cuenta) {
        Realm realm = Realm.getDefaultInstance();
        final Cuenta[] cuentas = {null};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                cuentas[0] = realm.createObject(Cuenta.class, cuenta.getNombre());
            }
        });
        realm.close();
        return cuentas[0];
    }

    @Override
    public void updateSaldo(Cuenta cuenta) {
        Realm.getDefaultInstance().insertOrUpdate(cuenta);
    }

    @Override
    public void deleteCuenta(String nombre) {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Cuenta> cuentas = realm.where(Cuenta.class).equalTo("nombre", nombre).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                cuentas.deleteAllFromRealm(); // indirectly delete object
            }
        });
        realm.close();
    }
}
