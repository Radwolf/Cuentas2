package org.rul.repository.datasource;


import org.rul.repository.datasource.base.DbDatasource;
import org.rul.repository.model.CuentaDb;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaDbDatasource extends DbDatasource<CuentaDb> {
    CuentaDb findByNombre(String nombre);
    void updateSaldo(CuentaDb cuentaDb);
    void deleteCuenta(String nombre);
}
