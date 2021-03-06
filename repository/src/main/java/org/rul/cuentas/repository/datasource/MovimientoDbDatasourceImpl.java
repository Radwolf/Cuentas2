package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 06/10/2016.
 */

public class MovimientoDbDatasourceImpl implements MovimientoDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public MovimientoDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public List<MovimientoDb> findAll() {
        return getRealm().where(MovimientoDb.class).findAll();
    }

    @Override
    public RealmResults<MovimientoDb> findAllFechaBorradoIsNull() {
        return getRealm().where(MovimientoDb.class).isNull("fechaBorrado").findAll();
    }

    @Override
    public List<MovimientoDb> insertAll(List<MovimientoDb> elementList) throws RepositoryException {
        getRealm().beginTransaction();
        List<MovimientoDb> returnedMovimientoDb = null;

        try {
            returnedMovimientoDb = getRealm().copyToRealm(elementList);
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return returnedMovimientoDb;
    }

    @Override
    public void remove(MovimientoDb movimientoDb) {
        getRealm().beginTransaction();
        RealmQuery<MovimientoDb> realmQuery = getRealm().where(MovimientoDb.class).equalTo(MovimientoDb.K_MOVIMIENTO_ID, movimientoDb.getId());
        RealmResults<MovimientoDb> realmResults = realmQuery.findAll();
        realmResults.deleteAllFromRealm();
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public void removeAll() {
        getRealm().beginTransaction();
        getRealm().delete(MovimientoDb.class);
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public RealmResults<MovimientoDb> findByTipoMovimiento(String tipoMovimiento) {
        return getRealm().where(MovimientoDb.class).equalTo("tipoMovimiento", tipoMovimiento).findAll();
    }

    @Override
    public MovimientoDb findById(int id) {
        return getRealm().where(MovimientoDb.class).equalTo("id", id).findFirst();
    }

    @Override
    public float getTotalGastosPrevistos(Date fechaInicio, Date fechaFin) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastos(Date fechaInicio, Date fechaFin) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosPrevistos(Date fechaInicio, Date fechaFin) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresos(Date fechaInicio, Date fechaFin) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoria(int idCategoria) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("categoria.id", idCategoria).findAll();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoriaAndPeriodo(int idCategoria, Date fechaInicio, Date fechaFin) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public float getTotalGastosByCuentaPrevistos(Date fechaInicio, Date fechaFin, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalGastosByCuenta(Date fechaInicio, Date fechaFin, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getGastosByCuentaAndCategoria(Date fechaInicio, Date fechaFin, int idCategoria, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "GASTO")
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public float getTotalIngresosByCuentaPrevistos(Date fechaInicio, Date fechaFin, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .between("fechaPrevista", fechaInicio, fechaFin).findAll()
                .sum("importePrevisto").floatValue();
    }

    @Override
    public float getTotalIngresosByCuenta(Date fechaInicio, Date fechaFin, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("tipoMovimiento", "INGRESO")
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll()
                .sum("importe").floatValue();
    }

    @Override
    public RealmResults<MovimientoDb> findByCategoriaAndPeriodoAndCuenta(int idCategoria, Date fechaInicio, Date fechaFin, String nombreCuenta) {
        return getRealm().where(MovimientoDb.class)
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .equalTo("categoria.id", idCategoria)
                .between("fechaConfirmacion", fechaInicio, fechaFin).findAll();
    }

    @Override
    public MovimientoDb insert(final MovimientoDb movimiento) throws RepositoryException {
        boolean inTransaction = false;
        if (getRealm().isInTransaction()) {
            inTransaction = true;
        }
        if (!inTransaction) {
            getRealm().beginTransaction();
        }
        ResumenCuentaDb resumenCuentaDb = getRealm().where(ResumenCuentaDb.class)
                .equalTo(ResumenCuentaDb.K_RESUMEN_CUENTA_ID, movimiento.getCategoriaDb().getId())
                .findFirst();
        CategoriaDb categoriaDb = getRealm().where(CategoriaDb.class)
                .equalTo(CategoriaDb.K_CATEGORIA_ID, movimiento.getCategoriaDb().getId())
                .findFirst();
        MovimientoDb movimientoDb = null;
        try {
            movimientoDb = getRealm().createObject(MovimientoDb.class, movimiento.getId());
            movimientoDb.setAhorro(movimiento.isAhorro());
            movimientoDb.setCategoriaDb(categoriaDb);
            movimientoDb.setResumenCuentaDb(resumenCuentaDb);
            movimientoDb.setDescripcion(movimiento.getDescripcion());
            movimientoDb.setFechaConfirmacion(movimiento.getFechaConfirmacion());
            movimientoDb.setFechaPrevista(movimiento.getFechaPrevista());
            movimientoDb.setImporte(movimiento.getImporte());
            movimientoDb.setImportePrevisto(movimiento.getImportePrevisto());
            movimientoDb.setTipoMovimiento(movimiento.getTipoMovimiento());

        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            if (!inTransaction) {
                getRealm().commitTransaction();
                getRealm().close();
            }
        }

        return movimientoDb;
    }

    @Override
    public void logicRemoveMovimiento(int id, Date fechaRemove) {
        boolean inTransaction = false;
        if (getRealm().isInTransaction()) {
            inTransaction = true;
        }
        if (!inTransaction) {
            getRealm().beginTransaction();
        }
        MovimientoDb movimientoDb = getRealm().where(MovimientoDb.class)
                .equalTo(MovimientoDb.K_MOVIMIENTO_ID, id).findFirst();
        movimientoDb.setFechaBorrado(fechaRemove);
        if (!inTransaction) {
            getRealm().commitTransaction();
            getRealm().close();
        }
    }

    public void updateMovimiento(MovimientoDb movimientoDb) {
        boolean inTransaction = false;
        if (getRealm().isInTransaction()) {
            inTransaction = true;
        }
        if (!inTransaction) {
            getRealm().beginTransaction();
        }
        getRealm().insertOrUpdate(movimientoDb);
        if (!inTransaction) {
            getRealm().commitTransaction();
            getRealm().close();
        }
    }

    @Override
    public void confirmaMovimiento(MovimientoDb movimientoDb) {
        updateMovimiento(movimientoDb);
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }

}
