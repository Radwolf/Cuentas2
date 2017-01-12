package org.rul.cuentas.repository.datasource.mapper;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.util.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaDomainMapper extends Mapper<CuentaDomain, CuentaDb> {

    private SimpleDateFormat sdf;

    @Inject
    public CuentaDomainMapper() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public CuentaDomain map(CuentaDb type) {
        return new CuentaDomain.Builder()
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .setFechaActualizacion(sdf.format(type.getFechaActualizacion()))
                .setSaldoPrevisto(type.getSaldoPrevisto())
                .build();
    }

    @Override
    public CuentaDb reverseMap(CuentaDomain type) {
        Date date = new Date();
        try {
            date = sdf.parse(type.getFechaActualizacion());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new CuentaDb.Builder()
                .setFechaActualizacion(date)
                .setNombre(type.getNombre())
                .setSaldo(type.getSaldo())
                .setSaldoPrevisto(type.getSaldoPrevisto())
                .build();
    }
}
