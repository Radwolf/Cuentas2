package org.rul.cuentas.mappers;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.ui.model.ResumenCuenta;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class ResumenCuentaUiMapper extends Mapper<ResumenCuenta, ResumenCuentaDomain> {

    private SimpleDateFormat sdf;

    @Inject
    public ResumenCuentaUiMapper() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public ResumenCuenta map(ResumenCuentaDomain type) {
        return new ResumenCuenta.Builder()
                .setNombreCuenta(type.getNombreCuenta())
                .setAnyoMes(type.getAnyoMes())
                .setAhorros(String.valueOf(type.getAhorros()))
                .setGastos(String.valueOf(type.getGastos()))
                .setIngresos(String.valueOf(type.getIngresos()))
                .build();
    }

    @Override
    public ResumenCuentaDomain reverseMap(ResumenCuenta type) {
        ResumenCuentaDomain resumenCuentaDomain = new ResumenCuentaDomain.Builder()
                .setNombreCuenta(type.getNombreCuenta())
                .setAnyoMes(type.getAnyoMes())
                .setAhorros(Float.parseFloat(type.getAhorros()))
                .setIngresos(Float.parseFloat(type.getIngresos()))
                .setGastos(Float.parseFloat(type.getGastos()))
                .build();
        return resumenCuentaDomain;
    }
}
