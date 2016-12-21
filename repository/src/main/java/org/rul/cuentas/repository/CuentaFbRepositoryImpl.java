package org.rul.cuentas.repository;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.datasource.mapper.CuentaDomainMapper;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.firebase.CuentaDbFirebase;
import org.rul.cuentas.repository.firebase.mapper.CuentaDomainMapperFb;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaFbRepositoryImpl implements CuentaFbRepository {

    private CuentaDomainMapperFb cuentaDomainMapperFb;
    private CuentaDbFirebase cuentaDbFirebase;

    @Inject
    public CuentaFbRepositoryImpl(CuentaDomainMapperFb cuentaDomainMapperFb, CuentaDbFirebase cuentaDbFirebase) {
        this.cuentaDomainMapperFb = cuentaDomainMapperFb;
        this.cuentaDbFirebase = cuentaDbFirebase;
    }

    @Override
    public List<CuentaDomain> findAll() {
        return cuentaDomainMapperFb.mapList(cuentaDbFirebase.findAll());
    }

    @Override
    public CuentaDomain insert(CuentaDomain element) throws RepositoryException {
        return null;
    }

    @Override
    public List<CuentaDomain> insertAll(List<CuentaDomain> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CuentaDomain element) {

    }

    @Override
    public void removeAll() {

    }
}
