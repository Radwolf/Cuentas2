package org.rul.cuentas.util;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.model.CuentaDb;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaDomainMapper  extends Mapper<CuentaDomain, CuentaDb> {

    @Inject
    public CuentaDomainMapper() {
    }

    @Override
    public CuentaDomain map(CuentaDb type) {
        return new CuentaDomain.Builder()
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .setFechaActualizacion(type.getFechaActualizacion())
                .build();
    }

    @Override
    public CuentaDb reverseMap(CuentaDomain type) {
        return new CuentaDb.Builder()
                .setFechaActualizacion(type.getFechaActualizacion())
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .build();
    }
}
