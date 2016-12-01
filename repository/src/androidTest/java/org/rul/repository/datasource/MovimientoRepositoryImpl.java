package org.rul.repository.datasource;



import org.rul.repository.exceptions.RepositoryException;
import org.rul.repository.model.Movimiento;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 06/10/2016.
 */

public class MovimientoRepositoryImpl implements MovimientoDbDatasource {


    @Override
    public RealmResults<Movimiento> findAll() {
        return Realm.getDefaultInstance().where(Movimiento.class).findAll();
    }

    @Override
    public List<Movimiento> insertAll(List<Movimiento> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(Movimiento element) {}

    @Override
    public void removeAll() {}

    @Override
    public RealmResults<Movimiento> findByTipoMovimiento(String tipoMovimiento) {
        return Realm.getDefaultInstance().where(Movimiento.class).equalTo("tipoMovimiento", tipoMovimiento).findAll();
    }

    @Override
    public Movimiento findById(int id) {
        return Realm.getDefaultInstance().where(Movimiento.class).equalTo("id", id).findFirst();
    }

    @Override
    public float getTotalGastosPrevistos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(Movimiento.class)
            .equalTo("tipoMovimiento", "GASTO")
            .between("fechaPrevista", fechaInicio, fechaFin).findAll()
            .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "GASTO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosPrevistos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<Movimiento> findByCategoria(int idCategoria) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("categoria.id", idCategoria).findAll();
    }

    @Override
    public RealmResults<Movimiento> findByCategoriaAndPeriodo(int idCategoria, Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public float getTotalGastosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getGastosByCuentaAndCategoria(Date fechaInicio, Date fechaFin, int idCuenta, int idCategoria) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<Movimiento> findByCategoriaAndPeriodoAndCuenta(int idCategoria, Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(Movimiento.class)
                .equalTo("cuenta.id", idCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public Movimiento insert(final Movimiento movimiento) {
        Realm realm = Realm.getDefaultInstance();
        final int lastId = realm.where(Movimiento.class).findAll().max("id").intValue();
        final Movimiento[] movimientos = {null};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                movimientos[0] = realm.createObject(Movimiento.class, lastId + 1);
            }
        });
        realm.close();
        return movimientos[0];
    }

    @Override
    public void updateMovimiento(Movimiento movimiento) {
        Realm.getDefaultInstance().insertOrUpdate(movimiento);
    }

    @Override
    public void confirmaMovimiento(Movimiento movimiento) {
        updateMovimiento(movimiento);
    }


}
