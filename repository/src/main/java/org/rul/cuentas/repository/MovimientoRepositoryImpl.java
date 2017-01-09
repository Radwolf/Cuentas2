package org.rul.cuentas.repository;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasource;
import org.rul.cuentas.repository.datasource.mapper.CuentaDomainMapper;
import org.rul.cuentas.repository.datasource.mapper.MovimientoDomainMapper;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class MovimientoRepositoryImpl implements MovimientoRepository {

    private MovimientoDomainMapper movimientoDomainMapper;
    private MovimientoDbDatasource movimientoDbDatasource;

    @Inject
    public MovimientoRepositoryImpl(MovimientoDomainMapper movimientoDomainMapper, MovimientoDbDatasource movimientoDbDatasource) {
        this.movimientoDomainMapper = movimientoDomainMapper;
        this.movimientoDbDatasource = movimientoDbDatasource;
    }

    @Override
    public List<MovimientoDomain> findAll() {
        return movimientoDomainMapper.mapList(movimientoDbDatasource.findAll());
    }

    @Override
    public MovimientoDomain insert(MovimientoDomain element) throws RepositoryException {
        return movimientoDomainMapper.map(movimientoDbDatasource.insert(movimientoDomainMapper.reverseMap(element)));
    }

    @Override
    public List<MovimientoDomain> insertAll(List<MovimientoDomain> elementList) throws RepositoryException {
        return movimientoDomainMapper.mapList(movimientoDbDatasource.insertAll(movimientoDomainMapper.reverseMapList(elementList)));
    }

    @Override
    public void remove(MovimientoDomain element) {
        movimientoDbDatasource.remove(movimientoDomainMapper.reverseMap(element));
    }

    @Override
    public void removeAll() {
        movimientoDbDatasource.removeAll();
    }

}
