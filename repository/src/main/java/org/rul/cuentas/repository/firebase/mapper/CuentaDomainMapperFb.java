package org.rul.cuentas.repository.firebase.mapper;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.firebase.model.CuentaFb;
import org.rul.cuentas.util.Mapper;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaDomainMapperFb  extends Mapper<CuentaDomain, CuentaFb> {

    @Inject
    public CuentaDomainMapperFb() {
    }

    @Override
    public CuentaDomain map(CuentaFb type) {
        return new CuentaDomain.Builder()
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .setFechaActualizacion(type.getFechaActualizacion())
                .build();
    }

    @Override
    public CuentaFb reverseMap(CuentaDomain type) {
        return new CuentaFb.Builder()
                .setFechaActualizacion(type.getFechaActualizacion())
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .build();
    }
}
