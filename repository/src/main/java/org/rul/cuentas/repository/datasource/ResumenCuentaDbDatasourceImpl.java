package org.rul.cuentas.repository.datasource;

import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class ResumenCuentaDbDatasourceImpl implements ResumenCuentaDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public ResumenCuentaDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public List<ResumenCuentaDb> findAll() {
        return getRealm().where(ResumenCuentaDb.class).findAll();
    }

    @Override
    public List<ResumenCuentaDb> insertAll(List<ResumenCuentaDb> elementList) throws RepositoryException {
        getRealm().beginTransaction();
        List<ResumenCuentaDb> returnedResumenCuentasDb = null;

        try {
            returnedResumenCuentasDb = getRealm().copyToRealm(elementList);
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            getRealm().commitTransaction();
            getRealm().close();
        }

        return returnedResumenCuentasDb;
    }

    @Override
    public void remove(ResumenCuentaDb element) {
        getRealm().beginTransaction();
        RealmQuery<ResumenCuentaDb> realmQuery = getRealm().where(ResumenCuentaDb.class)
                .equalTo("cuentaDb.nombre", element.getCuentaDb().getNombre())
                .equalTo("anyoMes", element.getAnyoMes());
        RealmResults<ResumenCuentaDb> realmResults = realmQuery.findAll();
        realmResults.deleteAllFromRealm();
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public void removeAll() {
        getRealm().beginTransaction();
        getRealm().delete(ResumenCuentaDb.class);
        getRealm().commitTransaction();
        getRealm().close();
    }

    @Override
    public ResumenCuentaDb insert(final ResumenCuentaDb resumenCuenta) throws RepositoryException {
        boolean inTransaction = false;
        if (getRealm().isInTransaction()) {
            inTransaction = true;
        }
        if (!inTransaction) {
            getRealm().beginTransaction();
        }
        ResumenCuentaDb resumenCuentaDb = null;
        try {
            ResumenCuentaDb resumenCuentaDbLast = getRealm().where(ResumenCuentaDb.class).findAllSorted("id", Sort.DESCENDING).first();
            resumenCuentaDb = getRealm().createObject(ResumenCuentaDb.class, resumenCuentaDbLast.getId() + 1);
            resumenCuentaDb.setCuentaDb(resumenCuenta.getCuentaDb());
            resumenCuentaDb.setAnyoMes(resumenCuenta.getAnyoMes());
            resumenCuentaDb.setAhorros(resumenCuenta.getAhorros());
            resumenCuentaDb.setGastos(resumenCuenta.getGastos());
            resumenCuentaDb.setIngresos(resumenCuenta.getIngresos());
            resumenCuentaDb.setAhorrosPrevistos(resumenCuenta.getAhorrosPrevistos());
            resumenCuentaDb.setGastosPrevistos(resumenCuenta.getGastosPrevistos());
            resumenCuentaDb.setIngresosPrevistos(resumenCuenta.getIngresosPrevistos());
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            if (!inTransaction) {
                getRealm().commitTransaction();
                getRealm().close();
            }
        }

        return resumenCuentaDb;
    }

    private String calculaSiguienteAnyoMes(String anyoMes) {
        int anyo = Integer.parseInt(anyoMes.substring(0, 3));
        int mes = Integer.parseInt(anyoMes.substring(4, 5));

        if (mes == 12) {
            return String.format("%d0%d", anyo + 1, 1);
        } else if (mes + 1 < 10) {
            return String.format("%d0%d", anyo, mes + 1);
        } else {
            return String.format("%d%d", anyo, mes + 1);
        }
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }

    @Override
    public ResumenCuentaDb findByCuentaMesAnyo(String nombreCuenta, String anyoMes) {
        RealmQuery<ResumenCuentaDb> realmQuery = getRealm().where(ResumenCuentaDb.class)
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .equalTo("anyoMes", anyoMes);
        return realmQuery.findFirst();
    }

    @Override
    public List<ResumenCuentaDb> findByResumenesActuales(String anyoMes) {
        RealmQuery<ResumenCuentaDb> realmQuery = getRealm().where(ResumenCuentaDb.class)
                .equalTo("anyoMes", anyoMes);
        return realmQuery.findAll();
    }

    @Override
    public ResumenCuentaDb updateIngresos(String nombreCuenta, float importe) {
        ResumenCuentaDb resumenCuenta = getRealm().where(ResumenCuentaDb.class)
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .findAllSorted("anyoMes").first();
        resumenCuenta.setIngresos(importe + resumenCuenta.getIngresos());
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(resumenCuenta);
        getRealm().commitTransaction();
        return resumenCuenta;
    }

    @Override
    public ResumenCuentaDb updateGastos(String nombreCuenta, float importe) {
        ResumenCuentaDb resumenCuenta = getRealm().where(ResumenCuentaDb.class)
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .findAllSorted("anyoMes").first();
        resumenCuenta.setGastos(importe + resumenCuenta.getGastos());
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(resumenCuenta);
        getRealm().commitTransaction();
        return resumenCuenta;
    }

    @Override
    public ResumenCuentaDb updateAhorros(String nombreCuenta, float importe) {
        ResumenCuentaDb resumenCuenta = getRealm().where(ResumenCuentaDb.class)
                .equalTo("cuentaDb.nombre", nombreCuenta)
                .findAllSorted("anyoMes").first();
        resumenCuenta.setAhorros(importe + resumenCuenta.getAhorros());
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(resumenCuenta);
        getRealm().commitTransaction();
        return resumenCuenta;
    }
}
