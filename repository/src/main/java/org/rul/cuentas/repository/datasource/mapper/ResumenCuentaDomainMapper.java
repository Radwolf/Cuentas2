package org.rul.cuentas.repository.datasource.mapper;

import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.util.Mapper;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class ResumenCuentaDomainMapper extends Mapper<ResumenCuentaDomain, ResumenCuentaDb> {

    private SimpleDateFormat sdf;

    @Inject
    public ResumenCuentaDomainMapper() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public ResumenCuentaDomain map(ResumenCuentaDb type) {
        return new ResumenCuentaDomain.Builder()
                .setFechaUltimaActualizacion(sdf.format(type.getCuentaDb().getFechaActualizacion()))
                .setNombreCuenta(type.getCuentaDb().getNombre())
                .setAnyoMes(type.getAnyoMes())
                .setIngresos(type.getIngresos())
                .setGastos(type.getGastos())
                .setAhorros(type.getAhorros())
                .setIngresosPrevistos(type.getIngresosPrevistos())
                .setGastosPrevistos(type.getGastosPrevistos())
                .setAhorrosPrevistos(type.getAhorrosPrevistos())
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
                .setIngresosPrevistos(type.getIngresosPrevistos())
                .setGastosPrevistos(type.getGastosPrevistos())
                .setAhorrosPrevistos(type.getAhorrosPrevistos())
                .build();
    }
}
