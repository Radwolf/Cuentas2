package org.rul.cuentas.repository;

import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.firebase.CuentaDbFirebase;
import org.rul.cuentas.repository.datasource.mapper.CuentaDomainMapper;
import org.rul.cuentas.repository.firebase.mapper.CuentaDomainMapperFb;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaRepositoryImpl implements CuentaRepository {

    private CuentaDomainMapper cuentaDomainMapper;
    private CuentaDomainMapperFb cuentaDomainMapperFb;
    private CuentaDbDatasource cuentaDbDatasource;
    private CuentaDbFirebase cuentaDbFirebase;

    @Inject
    public CuentaRepositoryImpl(CuentaDomainMapper cuentaDomainMapper, CuentaDomainMapperFb cuentaDomainMapperFb,
                                CuentaDbDatasource cuentaDbDatasource, CuentaDbFirebase cuentaDbFirebase) {
        this.cuentaDomainMapperFb = cuentaDomainMapperFb;
        this.cuentaDomainMapper = cuentaDomainMapper;
        this.cuentaDbDatasource = cuentaDbDatasource;
        this.cuentaDbFirebase = cuentaDbFirebase;
    }

    @Override
    public List<CuentaDomain> findAll() {
        return cuentaDomainMapper.mapList(cuentaDbDatasource.findAll());
    }

    @Override
    public CuentaDomain insert(CuentaDomain element) throws RepositoryException {
        return cuentaDomainMapper.map(cuentaDbDatasource.insert(cuentaDomainMapper.reverseMap(element)));
    }

    @Override
    public List<CuentaDomain> insertAll(List<CuentaDomain> elementList) throws RepositoryException {
        return cuentaDomainMapper.mapList(cuentaDbDatasource.insertAll(cuentaDomainMapper.reverseMapList(elementList)));
    }

    @Override
    public void remove(CuentaDomain element) {
        cuentaDbDatasource.remove(cuentaDomainMapper.reverseMap(element));
    }

    @Override
    public void removeAll() {
        cuentaDbDatasource.removeAll();
    }

    @Override
    public List<CuentaDomain> findAllFb() {
        return new ArrayList<>(); //cuentaDomainMapperFb.mapList(cuentaDbFirebase.findAll());
    }
}
