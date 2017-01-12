package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.datasource.base.DbDatasource;
import org.rul.cuentas.repository.datasource.model.CuentaDb;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaDbDatasource extends DbDatasource<CuentaDb> {
    CuentaDb findByNombre(String nombre);

    void updateSaldo(CuentaDb cuentaDb);
}
