package org.rul.cuentas.mappers;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.util.Mapper;

import java.text.ParseException;
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
                .setNombreCategoria(type.getNombreCategoria())
                .setId(String.valueOf(type.getId()))
                .setImporte(String.valueOf(type.getImporte()))
                .setImportePrevisto(String.valueOf(type.getImportePrevisto()))
                .setIdResumenCuenta(String.valueOf(type.getIdResumenCuenta()))
                .setTipoMovimiento(type.getTipoMovimiento())
                .setFechaConfirmacion(sdf.format(type.getFechaConfirmacion()))
                .setFechaPrevista(sdf.format(type.getFechaPrevista()))
                .setFechaPrevista(sdf.format(type.getFechaPrevista()))
                .build();

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
                .setIdResumenCuenta(Integer.parseInt(type.getIdResumenCuenta()))
                .setTipoMovimiento(type.getTipoMovimiento())
                .build();

        try {
            movimientoDomain.setFechaPrevista(type.getFechaPrevista()!=null?sdf.parse(type.getFechaPrevista()):null);
            movimientoDomain.setFechaConfirmacion(type.getFechaConfirmacion()!=null?sdf.parse(type.getFechaConfirmacion()):null);
            movimientoDomain.setFechaBorrado(type.getFechaBorrado()!=null?sdf.parse(type.getFechaBorrado()):null);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return movimientoDomain;
    }
}
