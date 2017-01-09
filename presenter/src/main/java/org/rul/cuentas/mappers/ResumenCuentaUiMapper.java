package org.rul.cuentas.mappers;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.ui.model.ResumenCuenta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        ResumenCuenta resumenCuenta = new ResumenCuenta.Builder()
                .setNombreCuenta(type.getNombreCuenta())
                .setAnyoMes(type.getAnyoMes())
                .setAhorros(String.valueOf(type.getAhorros()))
                .setGastos(String.valueOf(type.getGastos()))
                .setIngresos(String.valueOf(type.getIngresos()))
                .setIngresosPrevistos(String.valueOf(type.getIngresosPrevistos()))
                .setGastosPrevistos(String.valueOf(type.getGastosPrevistos()))
                .setAhorrosPrevistos(String.valueOf(type.getAhorrosPrevistos()))
                .build();

        if( type.getFechaUltimaActualizacion() != null ) {
            resumenCuenta.setFechaUltimaActualizacion( type.getFechaUltimaActualizacion() );
        }else{
            resumenCuenta.setFechaUltimaActualizacion(sdf.format(new Date()));
        }

        return resumenCuenta;
    }

    @Override
    public ResumenCuentaDomain reverseMap(ResumenCuenta type) {
        ResumenCuentaDomain resumenCuentaDomain = new ResumenCuentaDomain.Builder()
                .setFechaUltimaActualizacion(type.getFechaUltimaActualizacion())
                .setNombreCuenta(type.getNombreCuenta())
                .setAnyoMes(type.getAnyoMes())
                .setAhorros(Float.parseFloat(type.getAhorros()))
                .setIngresos(Float.parseFloat(type.getIngresos()))
                .setGastos(Float.parseFloat(type.getGastos()))
                .setIngresosPrevistos(Float.parseFloat(type.getIngresosPrevistos()))
                .setGastosPrevistos(Float.parseFloat(type.getGastosPrevistos()))
                .setAhorrosPrevistos(Float.parseFloat(type.getAhorrosPrevistos()))
                .build();
        return resumenCuentaDomain;
    }

}
