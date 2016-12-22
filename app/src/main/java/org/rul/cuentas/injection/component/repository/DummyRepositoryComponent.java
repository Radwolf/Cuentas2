package org.rul.cuentas.injection.component.repository;

import org.rul.cuentas.repository.DummyRepository;
import org.rul.cuentas.repository.datasource.DummyDbDatasource;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface DummyRepositoryComponent {

    DummyRepository dummyRepository();
    DummyDbDatasource dummyDatasource();
}
