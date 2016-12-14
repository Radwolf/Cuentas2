package org.rul.cuentas.repository;

import org.rul.cuentas.repository.datasource.DummyDbDatasource;

import java.io.InputStream;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class DummyRepositoryImpl implements DummyRepository {

    private DummyDbDatasource dummyDbDatasource;

    @Inject
    public DummyRepositoryImpl(DummyDbDatasource dummyDbDatasource) {
        this.dummyDbDatasource = dummyDbDatasource;
    }

    @Override
    public Object load(InputStream is) {
        dummyDbDatasource.loadDummy(is);
        return null;
    }

}
