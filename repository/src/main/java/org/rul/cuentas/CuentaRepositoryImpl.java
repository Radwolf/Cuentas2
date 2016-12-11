package org.rul.cuentas;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.datasource.CuentaDbDatasource;
import org.rul.cuentas.util.CuentaDomainMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaRepositoryImpl implements CuentaRepository {

    private CuentaDomainMapper cuentaDomainMapper;
    private CuentaDbDatasource cuentaDbDatasource;

    @Inject
    public CuentaRepositoryImpl(CuentaDomainMapper cuentaDomainMapper, CuentaDbDatasource cuentaDbDatasource) {

        this.cuentaDomainMapper = cuentaDomainMapper;
        this.cuentaDbDatasource = cuentaDbDatasource;

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
}
