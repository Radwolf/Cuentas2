package org.rul.cuentas.mappers;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.ui.model.Cuenta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class CuentaUiMapper extends Mapper<Cuenta, CuentaDomain> {

    private SimpleDateFormat sdf;

    @Inject
    public CuentaUiMapper() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public Cuenta map(CuentaDomain type) {
        return new Cuenta.Builder()
                .setNombre(type.getNombre())
                .setSaldo(String.valueOf(type.getSaldo()))
                .setFechaActualizacion((type.getFechaActualizacion() != null)?sdf.format(type.getFechaActualizacion()):null)
                .build();
    }

    @Override
    public CuentaDomain reverseMap(Cuenta type) {
        CuentaDomain cuentaDomain = new CuentaDomain.Builder()
                .setNombre(type.getNombre())
                .setSaldo(Float.parseFloat(type.getSaldo()))
                .build();

        try {
            if( type.getFechaActualizacion() != null ) {
                cuentaDomain.setFechaActualizacion(sdf.parse( type.getFechaActualizacion() ) );
            }else{
                cuentaDomain.setFechaActualizacion( new Date() );
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cuentaDomain;
    }
}