package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.datasource.base.DbDatasource;
import org.rul.cuentas.repository.model.CuentaDb;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface DummyDbDatasource extends DbDatasource<CuentaDb> {
    void loadDummy();
}
