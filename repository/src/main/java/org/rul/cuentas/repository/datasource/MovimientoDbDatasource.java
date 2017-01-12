package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.datasource.base.DbDatasource;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;

import java.util.Date;

import io.realm.RealmResults;

/**
 * Created by rgonzalez on 06/10/2016.
 */

public interface MovimientoDbDatasource extends DbDatasource<MovimientoDb> {

    RealmResults<MovimientoDb> findAllFechaBorradoIsNull();

    RealmResults<MovimientoDb> findByTipoMovimiento(String tipoMovimiento);

    MovimientoDb findById(int id);

    //Movimientos para vista global
    //Devuelve el total de gastos de un periodo
    float getTotalGastosPrevistos(Date fechaInicio, Date fechaFin);

    float getTotalGastos(Date fechaInicio, Date fechaFin);

    //Devuelve el total de ingresos de un periodo
    float getTotalIngresosPrevistos(Date fechaInicio, Date fechaFin);

    float getTotalIngresos(Date fechaInicio, Date fechaFin);

    RealmResults<MovimientoDb> findByCategoria(int idCategoria);

    RealmResults<MovimientoDb> findByCategoriaAndPeriodo(int idCategoria, Date fechaInicio, Date fechaFin);

    //Movimientos por cuenta
    float getTotalGastosByCuentaPrevistos(Date fechaInicio, Date fechaFin, String nombreCuenta);

    float getTotalGastosByCuenta(Date fechaInicio, Date fechaFin, String nombreCuenta);

    float getGastosByCuentaAndCategoria(Date fechaInicio, Date fechaFin, int idCategoria, String nombreCuenta);

    float getTotalIngresosByCuentaPrevistos(Date fechaInicio, Date fechaFin, String nombreCuenta);

    float getTotalIngresosByCuenta(Date fechaInicio, Date fechaFin, String nombreCuenta);

    RealmResults<MovimientoDb> findByCategoriaAndPeriodoAndCuenta(int idCategoria, Date fechaInicio, Date fechaFin, String nombreCuenta);


    void logicRemoveMovimiento(int id, Date fechaRemove);

    void confirmaMovimiento(MovimientoDb movimientoDb);


}
