package org.rul.repository;

import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.repository.ResumenCuentaRepository;
import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.datasource.CuentaDbDatasource;
import org.rul.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.repository.util.CuentaDomainMapper;
import org.rul.repository.util.ResumenCuentaDomainMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class ResumenCuentaRepositoryImpl implements ResumenCuentaRepository {

    private ResumenCuentaDomainMapper resumenCuentaDomainMapper;
    private ResumenCuentaDbDatasource resumenCuentaDbDatasource;

    @Inject
    public ResumenCuentaRepositoryImpl(ResumenCuentaDomainMapper resumenCuentaDomainMapper,
                                       ResumenCuentaDbDatasource resumenCuentaDbDatasource) {

        this.resumenCuentaDbDatasource = resumenCuentaDbDatasource;
        this.resumenCuentaDomainMapper = resumenCuentaDomainMapper;

    }
    @Override
    public List<ResumenCuentaDomain> findAll() {
        return resumenCuentaDomainMapper.mapList(resumenCuentaDbDatasource.findAll());
    }

    @Override
    public ResumenCuentaDomain insert(ResumenCuentaDomain element) throws RepositoryException {
        return resumenCuentaDomainMapper.map(resumenCuentaDbDatasource.insert(resumenCuentaDomainMapper.reverseMap(element)));
    }

    @Override
    public List<ResumenCuentaDomain> insertAll(List<ResumenCuentaDomain> elementList) throws RepositoryException {
        return resumenCuentaDomainMapper.mapList(resumenCuentaDbDatasource.insertAll(resumenCuentaDomainMapper.reverseMapList(elementList)));
    }

    @Override
    public void remove(ResumenCuentaDomain element) {
        resumenCuentaDbDatasource.remove(resumenCuentaDomainMapper.reverseMap(element));
    }

    @Override
    public void removeAll() {
        resumenCuentaDbDatasource.removeAll();
    }

    @Override
    public List<ResumenCuentaDomain> findByResumenesActuales(String anyoMes) {
        return resumenCuentaDomainMapper.mapList(resumenCuentaDbDatasource.findByResumenesActuales(anyoMes));
    }

    @Override
    public ResumenCuentaDomain findByCuentaMesAnyo(String nombreCuenta, String anyoMes) {
        return resumenCuentaDomainMapper.map(resumenCuentaDbDatasource.findByCuentaMesAnyo(nombreCuenta, anyoMes));
    }

    @Override
    public ResumenCuentaDomain updateIngresos(String nombreCuenta, float importe) {
        return resumenCuentaDomainMapper.map(resumenCuentaDbDatasource.updateIngresos(nombreCuenta, importe));
    }

    @Override
    public ResumenCuentaDomain updateGastos(String nombreCuenta, float importe) {
        return resumenCuentaDomainMapper.map(resumenCuentaDbDatasource.updateGastos(nombreCuenta, importe));
    }

    @Override
    public ResumenCuentaDomain updateAhorros(String nombreCuenta, float importe) {
        return resumenCuentaDomainMapper.map(resumenCuentaDbDatasource.updateAhorros(nombreCuenta, importe));
    }
}
