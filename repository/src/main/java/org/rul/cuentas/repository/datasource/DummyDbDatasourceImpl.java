package org.rul.cuentas.repository.datasource;

import com.google.common.base.Strings;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class DummyDbDatasourceImpl implements DummyDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public DummyDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public void loadDummy(InputStream is) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(is.toString());
        //try {
        // InputStream is = new FileInputStream(new File("cuentas2.json"));
        //} catch (FileNotFoundException e) {
        //  System.out.println(e.getMessage());
        //}
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder out = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            System.out.println(out.toString());   //Prints the string content read from input stream
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // make sure the quotes are escaped
        String str = out.toString();
        // the object data is inside a "global" JSONObject
        JSONArray categorias;
        JSONArray cuentas;
        JSONArray resumenCuentas;
        JSONArray movimientos;
        getRealm().beginTransaction();
        //Para Borrar las tablas OJO comentarlo
        getRealm().delete(CategoriaDb.class);
        getRealm().delete(CuentaDb.class);
        getRealm().delete(ResumenCuentaDb.class);
        getRealm().delete(MovimientoDb.class);

        try {
            categorias = new JSONObject(str).getJSONArray("categoria");
            for (int i = 0; i < categorias.length(); i++) {
                JSONObject categoria = categorias.getJSONObject(i);
                CategoriaDb categoriaDb = null;
                categoriaDb = getRealm().createObject(CategoriaDb.class, i + 1);
                categoriaDb.setNombre(categoria.getString("nombre"));
            }
            cuentas = new JSONObject(str).getJSONArray("cuenta");
            for (int i = 0; i < cuentas.length(); i++) {
                JSONObject cuenta = cuentas.getJSONObject(i);
                CuentaDb cuentaDb = null;
                cuentaDb = getRealm().createObject(CuentaDb.class, cuenta.getString("nombre"));
                cuentaDb.setSaldo(Float.parseFloat(cuenta.getString("saldo")));
                cuentaDb.setFechaActualizacion(Calendar.getInstance().getTime());
            }
            resumenCuentas = new JSONObject(str).getJSONArray("resumen_cuenta");
            for (int i = 0; i < resumenCuentas.length(); i++) {
                JSONObject resumenCuenta = resumenCuentas.getJSONObject(i);
                CuentaDb cuentaDb = getRealm().where(CuentaDb.class).equalTo("nombre", resumenCuenta.getString("cuentaDb")).findFirst();
                ResumenCuentaDb resumenCuentaDb = null;
                resumenCuentaDb = getRealm().createObject(ResumenCuentaDb.class, i + 1);
                resumenCuentaDb.setCuentaDb(cuentaDb);
                resumenCuentaDb.setAnyoMes(resumenCuenta.getString("anyomes"));
                resumenCuentaDb.setAhorros(Float.parseFloat(resumenCuenta.getString("ahorros")));
                resumenCuentaDb.setGastos(Float.parseFloat(resumenCuenta.getString("gastos")));
                resumenCuentaDb.setIngresos(Float.parseFloat(resumenCuenta.getString("ingresos")));
            }
            movimientos = new JSONObject(str).getJSONArray("movimientos");
            for (int i = 0; i < movimientos.length(); i++) {
                JSONObject movimiento = movimientos.getJSONObject(i);
                MovimientoDb movimientoDb = getRealm().createObject(MovimientoDb.class, i + 1);
                ResumenCuentaDb resumenCuentaDb = getRealm().where(ResumenCuentaDb.class).equalTo("id", movimiento.getInt("resumenCuentaDb")).findFirst();
                CategoriaDb categoriaDb = getRealm().where(CategoriaDb.class).equalTo("id", movimiento.getInt("categoria")).findFirst();
                movimientoDb.setAhorro(Boolean.parseBoolean(movimiento.getString("es_ahorro")));
                movimientoDb.setCategoriaDb(categoriaDb);
                movimientoDb.setResumenCuentaDb(resumenCuentaDb);
                movimientoDb.setDescripcion(movimiento.getString("descripcion"));
                movimientoDb.setFechaConfirmacion((!Strings.isNullOrEmpty(movimiento.getString("fecha_confirmacion"))) ? formatter.parse(movimiento.getString("fecha_confirmacion")) : null);
                movimientoDb.setFechaPrevista((!Strings.isNullOrEmpty(movimiento.getString("fecha_prevista"))) ? formatter.parse(movimiento.getString("fecha_prevista")) : null);
                float importe = Float.parseFloat(movimiento.getString("importe"));
                movimientoDb.setImporte(importe);
                float importePrevisto = Float.parseFloat(movimiento.getString("importe_previsto"));
                movimientoDb.setImportePrevisto(importePrevisto);
                movimientoDb.setTipoMovimiento(movimiento.getString("tipo_movimiento"));

                String tipoMovimiento = movimiento.getString("tipo_movimiento");

                if ("INGRESO".equals(tipoMovimiento)) {
                    if (importe == 0) {
                        resumenCuentaDb.setIngresosPrevistos(importePrevisto + resumenCuentaDb.getIngresosPrevistos());
                    } else {
                        resumenCuentaDb.setIngresos(importe + resumenCuentaDb.getIngresos());
                    }
                }
                if ("GASTO".equals(tipoMovimiento)) {
                    if (importe == 0) {
                        resumenCuentaDb.setGastosPrevistos(importePrevisto + resumenCuentaDb.getGastosPrevistos());
                    } else {
                        resumenCuentaDb.setGastos(importe + resumenCuentaDb.getGastos());
                    }
                }
                if ("AHORRO".equals(tipoMovimiento)) {
                    if (importe == 0) {
                        resumenCuentaDb.setAhorrosPrevistos(importePrevisto + resumenCuentaDb.getAhorrosPrevistos());
                    } else {
                        resumenCuentaDb.setAhorros(importe + resumenCuentaDb.getAhorros());
                    }
                }
                getRealm().copyToRealmOrUpdate(resumenCuentaDb);
            }
            //Para hacerlo desde el JSON directamente
            //getRealm().createAllFromJson(CuentaDb.class, cuentas.toString());
            //getRealm().createAllFromJson(ResumenCuentaDb.class, resumenCuentas.toString());
            //getRealm().createAllFromJson(MovimientoDb.class, movimientos.toString());
            getRealm().commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            getRealm().cancelTransaction();
        }

        /*getRealm().beginTransaction();
        try {
            getRealm().createAllFromJson(City.class, is);
            getRealm().commitTransaction();
        } catch (IOException e) {
            getRealm().cancelTransaction();
        }*/
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }


    @Override
    public List<CuentaDb> findAll() {
        return null;
    }

    @Override
    public CuentaDb insert(CuentaDb element) throws RepositoryException {
        return null;
    }

    @Override
    public List<CuentaDb> insertAll(List<CuentaDb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CuentaDb element) {

    }

    @Override
    public void removeAll() {

    }
}
