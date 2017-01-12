package org.rul.cuentas.repository;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.mapper.ResumenCuentaDomainMapper;
import org.rul.cuentas.repository.exceptions.RepositoryException;

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
