package org.rul.cuentas.repository;

import org.rul.cuentas.model.Categoria;
import org.rul.cuentas.model.Cuenta;

import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaRepository extends Repository<Cuenta> {
    Cuenta findByNombre(String nombre);
    void updateSaldo(Cuenta cuenta);
    void deleteCuenta(String nombre);
}
