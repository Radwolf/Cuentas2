package org.rul.cuentas.repository.datasource.mapper;

import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.util.Mapper;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class MovimientoDomainMapper extends Mapper<MovimientoDomain, MovimientoDb> {

    @Inject
    public MovimientoDomainMapper() {
    }

    @Override
    public MovimientoDomain map(MovimientoDb type) {
        return null;
    }

    @Override
    public MovimientoDb reverseMap(MovimientoDomain type) {
        return null;
    }
}
