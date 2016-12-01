package org.rul.repository.datasource;



import org.rul.repository.datasource.base.DbDatasource;
import org.rul.repository.model.Movimiento;

import java.util.Date;

import io.realm.RealmResults;

/**
 * Created by rgonzalez on 06/10/2016.
 */

public interface MovimientoDbDatasource extends DbDatasource<Movimiento> {

    RealmResults<Movimiento> findByTipoMovimiento(String tipoMovimiento);
    Movimiento findById(int id);

    //Movimientos para vista global
    //Devuelve el total de gastos de un periodo
    float getTotalGastosPrevistos(Date fechaInicio, Date fechaFin);
    float getTotalGastos(Date fechaInicio, Date fechaFin);
    //Devuelve el total de ingresos de un periodo
    float getTotalIngresosPrevistos(Date fechaInicio, Date fechaFin);
    float getTotalIngresos(Date fechaInicio, Date fechaFin);
    RealmResults<Movimiento> findByCategoria(int idCategoria);
    RealmResults<Movimiento> findByCategoriaAndPeriodo(int idCategoria, Date fechaInicio, Date fechaFin);

    //Movimientos por cuenta
    float getTotalGastosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta);
    float getTotalGastosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta);
    float getGastosByCuentaAndCategoria(Date fechaInicio, Date fechaFin, int idCuenta, int idCategoria);
    float getTotalIngresosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta);
    float getTotalIngresosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta);
    RealmResults<Movimiento> findByCategoriaAndPeriodoAndCuenta(int idCategoria, Date fechaInicio, Date fechaFin, int idCuenta);


    void updateMovimiento (Movimiento movimiento);
    void confirmaMovimiento (Movimiento movimiento);


}
