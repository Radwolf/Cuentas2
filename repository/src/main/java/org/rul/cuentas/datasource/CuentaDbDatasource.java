package org.rul.cuentas.datasource;


import org.rul.cuentas.datasource.base.DbDatasource;
import org.rul.cuentas.model.CuentaDb;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaDbDatasource extends DbDatasource<CuentaDb> {
    CuentaDb findByNombre(String nombre);
    void updateSaldo(CuentaDb cuentaDb);
}
