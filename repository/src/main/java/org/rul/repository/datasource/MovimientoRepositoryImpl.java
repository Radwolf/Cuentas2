package org.rul.repository.datasource;



import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.model.MovimientoDb;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 06/10/2016.
 */

public class MovimientoRepositoryImpl implements MovimientoDbDatasource {


    @Override
    public RealmResults<MovimientoDb> findAll() {
        return Realm.getDefaultInstance().where(MovimientoDb.class).findAll();
    }

    @Override
    public List<MovimientoDb> insertAll(List<MovimientoDb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(MovimientoDb element) {}

    @Override
    public void removeAll() {}

    @Override
    public RealmResults<MovimientoDb> findByTipoMovimiento(String tipoMovimiento) {
        return Realm.getDefaultInstance().where(MovimientoDb.class).equalTo("tipoMovimiento", tipoMovimiento).findAll();
    }

    @Override
    public MovimientoDb findById(int id) {
        return Realm.getDefaultInstance().where(MovimientoDb.class).equalTo("id", id).findFirst();
    }

    @Override
    public float getTotalGastosPrevistos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
            .equalTo("tipoMovimiento", "GASTO")
            .between("fechaPrevista", fechaInicio, fechaFin).findAll()
            .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosPrevistos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresos(Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoria(int idCategoria) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("categoria.id", idCategoria).findAll();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoriaAndPeriodo(int idCategoria, Date fechaInicio, Date fechaFin) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public float getTotalGastosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getGastosByCuentaAndCategoria(Date fechaInicio, Date fechaFin, int idCuenta, int idCategoria) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuenta.id", idCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosByCuentaPrevistos(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresosByCuenta(Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuenta.id", idCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoriaAndPeriodoAndCuenta(int idCategoria, Date fechaInicio, Date fechaFin, int idCuenta) {
        return Realm.getDefaultInstance().where(MovimientoDb.class)
                .equalTo("cuenta.id", idCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public MovimientoDb insert(final MovimientoDb movimientoDb) {
        Realm realm = Realm.getDefaultInstance();
        final int lastId = realm.where(MovimientoDb.class).findAll().max("id").intValue();
        final MovimientoDb[] movimientoDbs = {null};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                movimientoDbs[0] = realm.createObject(MovimientoDb.class, lastId + 1);
            }
        });
        realm.close();
        return movimientoDbs[0];
    }

    @Override
    public void updateMovimiento(MovimientoDb movimientoDb) {
        Realm.getDefaultInstance().insertOrUpdate(movimientoDb);
    }

    @Override
    public void confirmaMovimiento(MovimientoDb movimientoDb) {
        updateMovimiento(movimientoDb);
    }


}
