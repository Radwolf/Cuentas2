package org.rul.cuentas.injection.component.repository;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.datasource.CategoriaDbDatasource;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasource;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface CuentaRepositoryComponent {

    CuentaRepository cuentaRepository();

    Mapper<CuentaDomain, CuentaDb> cuentaDomainMapper();
    CuentaDbDatasource cuentaDbDatasource();
    CategoriaDbDatasource categoriaDbDatasource();
    MovimientoDbDatasource movimientoDbDatasource();
    ResumenCuentaDbDatasource resumenCuentaDbDatasource();
}
