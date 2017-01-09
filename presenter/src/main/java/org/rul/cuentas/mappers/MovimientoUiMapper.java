package org.rul.cuentas.mappers;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.util.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class MovimientoUiMapper extends Mapper<Movimiento, MovimientoDomain> {

    private SimpleDateFormat sdf;

    @Inject
    public MovimientoUiMapper() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public Movimiento map(MovimientoDomain type) {
        Movimiento movimiento = new Movimiento.Builder()
                .setAhorro(String.valueOf(type.isAhorro()))
                .setDescripcion(type.getDescripcion())
                .setIdCategoria(String.valueOf(type.getIdCategoria()))
                .setId(String.valueOf(type.getId()))
                .setImporte(String.valueOf(type.getImporte()))
                .setImportePrevisto(String.valueOf(type.getImportePrevisto()))
                .setNombreCuenta(type.getNombreCuenta())
                .setTipoMovimiento(type.getTipoMovimiento())
                .build();
        if(type.getFechaConfirmacion() != null){
            movimiento.setFechaConfirmacion(type.getFechaConfirmacion());
        }else{
            movimiento.setFechaConfirmacion(sdf.format(new Date()));
        }
        if(type.getFechaPrevista() != null){
            movimiento.setFechaPrevista(type.getFechaPrevista());
        }else{
            movimiento.setFechaPrevista(sdf.format(new Date()));
        }
        return movimiento;
    }

    @Override
    public MovimientoDomain reverseMap(Movimiento type) {
        MovimientoDomain movimientoDomain = new MovimientoDomain.Builder()
                .setAhorro(Boolean.parseBoolean(type.getAhorro()))
                .setDescripcion(type.getDescripcion())
                .setId(Integer.parseInt(type.getId()))
                .setIdCategoria(Integer.parseInt(type.getIdCategoria()))
                .setImporte(Float.parseFloat((type.getImporte()==null)?"0":type.getImporte()))
                .setImportePrevisto(Float.parseFloat((type.getImporte()==null)?"0":type.getImportePrevisto()))
                .setNombreCuenta(type.getNombreCuenta())
                .setTipoMovimiento(type.getTipoMovimiento())
                .setFechaConfirmacion(type.getFechaConfirmacion())
                .setFechaPrevista(type.getFechaPrevista())
                .build();

        return movimientoDomain;
    }
}
