package org.rul.cuentas.injection.component.repository;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.repository.ResumenCuentaRepository;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface ResumenCuentaRepositoryComponent {

    Mapper<ResumenCuentaDomain, ResumenCuentaDb> resumenCuentaDomainMapper();
    ResumenCuentaRepository resumenCuentaRepository();
    ResumenCuentaDbDatasource resumenCuentaDbDatasource();

}
