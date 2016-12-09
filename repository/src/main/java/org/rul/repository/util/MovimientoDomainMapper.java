package org.rul.repository.util;

import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.MovimientoDomain;
import org.rul.domain.util.Mapper;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.model.MovimientoDb;

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
