package org.rul.repository.datasource;


import org.rul.repository.datasource.base.DbDatasource;
import org.rul.repository.model.Cuenta;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaDbDatasource extends DbDatasource<Cuenta> {
    Cuenta findByNombre(String nombre);
    void updateSaldo(Cuenta cuenta);
    void deleteCuenta(String nombre);
}
