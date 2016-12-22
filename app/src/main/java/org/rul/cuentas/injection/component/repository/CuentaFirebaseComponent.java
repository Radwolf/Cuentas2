package org.rul.cuentas.injection.component.repository;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaFbRepository;
import org.rul.cuentas.repository.datasource.DummyDbDatasource;
import org.rul.cuentas.repository.firebase.CuentaDbFirebase;
import org.rul.cuentas.repository.firebase.model.CuentaFb;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface CuentaFirebaseComponent {

    Mapper<CuentaDomain, CuentaFb> cuentaDomainMapperFb();
    CuentaFbRepository cuentaFbRepository();
    CuentaDbFirebase cuentaDbFirebase();
}
