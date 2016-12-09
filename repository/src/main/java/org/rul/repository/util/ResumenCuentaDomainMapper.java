package org.rul.repository.util;

import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.domain.util.Mapper;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.model.ResumenCuentaDb;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class ResumenCuentaDomainMapper extends Mapper<ResumenCuentaDomain, ResumenCuentaDb> {

    @Inject
    public ResumenCuentaDomainMapper() {
    }

    @Override
    public ResumenCuentaDomain map(ResumenCuentaDb type) {
        return new ResumenCuentaDomain.Builder()
                .setNombreCuenta(type.getCuentaDb().getNombre())
                .setAnyoMes(type.getAnyoMes())
                .setIngresos(type.getIngresos())
                .setGastos(type.getGastos())
                .setAhorros(type.getAhorros())
                .build();
    }


    //TODO: como soluciono el reverse de un objeto domain a un db
    @Override
    public ResumenCuentaDb reverseMap(ResumenCuentaDomain type) {
        CuentaDb cuentaDb = new CuentaDb.Builder()
                .setNombre(type.getNombreCuenta()).build();
        return new ResumenCuentaDb.Builder()
                .setCuentaDb(cuentaDb)
                .setAnyoMes(type.getAnyoMes())
                .setIngresos(type.getIngresos())
                .setGastos(type.getGastos())
                .setAhorros(type.getAhorros())
                .build();
    }
}
