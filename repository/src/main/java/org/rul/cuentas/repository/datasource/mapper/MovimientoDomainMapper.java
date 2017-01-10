package org.rul.cuentas.repository.datasource.mapper;

import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.util.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class MovimientoDomainMapper extends Mapper<MovimientoDomain, MovimientoDb> {

    private SimpleDateFormat sdf;

    @Inject
    public MovimientoDomainMapper()  {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public MovimientoDomain map(MovimientoDb type) {
        return new MovimientoDomain.Builder()
                .setDescripcion(type.getDescripcion())
                .setAhorro(type.isAhorro())
                .setFechaConfirmacion(type.getFechaConfirmacion())
                .setFechaPrevista(type.getFechaPrevista())
                .setFechaBorrado(type.getFechaBorrado())
                .setId(type.getId())
                .setIdCategoria(type.getCategoriaDb().getId())
                .setNombreCategoria(type.getCategoriaDb().getNombre())
                .setImporte(type.getImporte())
                .setImportePrevisto(type.getImportePrevisto())
                .setTipoMovimiento(type.getTipoMovimiento())
                .build();
    }

    @Override
    public MovimientoDb reverseMap(MovimientoDomain type) {
        CategoriaDb categoriaDb = new CategoriaDb.Builder()
                .setId(type.getIdCategoria())
                .build();
        ResumenCuentaDb resumenCuentaDb = new ResumenCuentaDb.Builder()
                .setId(type.getIdResumenCuenta())
                .build();
        MovimientoDb movimientoDb = new MovimientoDb.Builder()
                .setDescripcion(type.getDescripcion())
                .setAhorro(type.isAhorro())
                .setId(type.getId())
                .setImporte(type.getImporte())
                .setImportePrevisto(type.getImportePrevisto())
                .setCategoriaDb(categoriaDb)
                .setResumenCuentaDb(resumenCuentaDb)
                .setFechaConfirmacion(type.getFechaConfirmacion())
                .setFechaPrevista(type.getFechaPrevista())
                .setFechaBorrado(type.getFechaBorrado())
                .build();

         return movimientoDb;
    }
}
