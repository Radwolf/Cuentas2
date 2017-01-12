package org.rul.cuentas.repository.datasource;

import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaDbDatasourceImpl implements CuentaDbDatasource {

    private RealmProvider realmProvider;
    private CategoriaDbDatasource categoriaDbDatasource;
    private MovimientoDbDatasource movimientoDbDatasource;
    private ResumenCuentaDbDatasource resumenCuentaDbDatasource;

    @Inject
    public CuentaDbDatasourceImpl(RealmProvider realmProvider, CategoriaDbDatasource categoriaDbDatasource,
                                  MovimientoDbDatasource movimientoDbDatasource,
                                  ResumenCuentaDbDatasource resumenCuentaDbDatasource) {
        this.realmProvider = realmProvider;
        this.categoriaDbDatasource = categoriaDbDatasource;
        this.movimientoDbDatasource = movimientoDbDatasource;
        this.resumenCuentaDbDatasource = resumenCuentaDbDatasource;
    }

    @Override
    public List<CuentaDb> findAll() {
        return getRealm().where(CuentaDb.class).findAll();
    }

    @Override
    public List<CuentaDb> insertAll(List<CuentaDb> elementList) throws RepositoryException {
        getRealm().beginTransaction();
        List<CuentaDb> returnedCuentasDb = null;

        try {
            returnedCuentasDb = getRealm().copyToRealm(elementList);
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return returnedCuentasDb;
    }

    @Override
    public void remove(CuentaDb element) {
        getRealm().beginTransaction();
        RealmQuery<CuentaDb> realmQuery = getRealm().where(CuentaDb.class).equalTo(CuentaDb.K_CUENTA_NOMBRE, element.getNombre());
        RealmResults<CuentaDb> realmResults = realmQuery.findAll();
        realmResults.deleteAllFromRealm();
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public void removeAll() {
        getRealm().beginTransaction();
        getRealm().delete(CuentaDb.class);
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public CuentaDb findByNombre(String nombre) {
        return getRealm().where(CuentaDb.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public CuentaDb insert(final CuentaDb cuenta) throws RepositoryException {
        getRealm().beginTransaction();
        CuentaDb cuentaDb = null;
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        try {
            cuentaDb = getRealm().createObject(CuentaDb.class, cuenta.getNombre());
            cuentaDb.setSaldo(cuenta.getSaldo());
            cuentaDb.setFechaActualizacion(Calendar.getInstance().getTime());

            int idResumen = getRealm().where(ResumenCuentaDb.class).findAll().max("id").intValue() + 1;

            ResumenCuentaDb resumenCuentaDb = new ResumenCuentaDb.Builder()
                    .setId(idResumen)
                    .setCuentaDb(cuentaDb)
                    .setAnyoMes(calculaSiguienteAnyoMes(year, month))
                    .setAhorros(0)
                    .setGastos(0)
                    .setIngresos(cuenta.getSaldo())
                    .setAhorrosPrevistos(0)
                    .setGastosPrevistos(0)
                    .setIngresosPrevistos(0).build();

            this.resumenCuentaDbDatasource.insert(resumenCuentaDb);

            CategoriaDb categoriaDb = this.categoriaDbDatasource.findByNombre("Ingreso"); // getRealm().where(CategoriaDb.class).equalTo("nombre", "Ingreso").findFirst();

            int idMovimiento = getRealm().where(MovimientoDb.class).findAll().max("id").intValue() + 1;
            MovimientoDb movimientoDb = new MovimientoDb.Builder()
                    .setId(idMovimiento)
                    .setAhorro(false)
                    .setImporte(cuenta.getSaldo())
                    .setDescripcion("Saldo inicial")
                    .setTipoMovimiento("INGRESO")
                    .setFechaConfirmacion(Calendar.getInstance().getTime())
                    .setResumenCuentaDb(resumenCuentaDb)
                    .setCategoriaDb(categoriaDb).build();

            this.movimientoDbDatasource.insert(movimientoDb);

            for (int i = month + 1; i <= 12; i++) {
                idResumen++;
                resumenCuentaDb = new ResumenCuentaDb.Builder()
                        .setId(idResumen)
                        .setCuentaDb(cuentaDb)
                        .setAnyoMes(calculaSiguienteAnyoMes(year, i))
                        .setAhorros(0)
                        .setGastos(0)
                        .setIngresos(0)
                        .setAhorrosPrevistos(0)
                        .setGastosPrevistos(0)
                        .setIngresosPrevistos(0).build();
                this.resumenCuentaDbDatasource.insert(resumenCuentaDb);
            }
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return cuentaDb;
    }

    private String calculaSiguienteAnyoMes(int anyo, int mes) {
        if (mes + 1 < 10) {
            return String.format("%d0%d", anyo, mes);
        } else {
            return String.format("%d%d", anyo, mes);
        }
    }

    @Override
    public void updateSaldo(CuentaDb cuenta) {
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(cuenta);
        getRealm().commitTransaction();
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }
}
