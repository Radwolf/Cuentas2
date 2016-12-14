package org.rul.cuentas.repository.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rgonzalez on 09/12/2016.
 */

public class ResumenCuentaDb extends RealmObject {

    public static final String K_RESUMEN_CUENTA_ID = "id";

    @PrimaryKey
    private int id;
    private CuentaDb cuentaDb;
    private String anyoMes;
    private float ingresos;
    private float gastos;
    private float ahorros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CuentaDb getCuentaDb() {
        return cuentaDb;
    }

    public void setCuentaDb(CuentaDb cuentaDb) {
        this.cuentaDb = cuentaDb;
    }

    public String getAnyoMes() {
        return anyoMes;
    }

    public void setAnyoMes(String anyoMes) {
        this.anyoMes = anyoMes;
    }

    public float getIngresos() {
        return ingresos;
    }

    public void setIngresos(float ingresos) {
        this.ingresos = ingresos;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }

    public float getAhorros() {
        return ahorros;
    }

    public void setAhorros(float ahorros) {
        this.ahorros = ahorros;
    }

    public ResumenCuentaDb() {
    }

    public ResumenCuentaDb(Builder builder){
        this.cuentaDb = builder.cuentaDb;
        this.anyoMes = builder.anyoMes;
        this.ahorros = builder.ahorros;
        this.gastos = builder.gastos;
        this.ingresos = builder.ingresos;
    }

    public static class Builder {

        private CuentaDb cuentaDb;
        private String anyoMes;
        private float ingresos;
        private float gastos;
        private float ahorros;

        public Builder setCuentaDb(CuentaDb cuentaDb) {
            this.cuentaDb = cuentaDb;
            return this;
        }

        public Builder setAnyoMes(String anyoMes) {
            this.anyoMes = anyoMes;
            return this;
        }

        public Builder setIngresos(float ingresos) {
            this.ingresos = ingresos;
            return this;
        }

        public Builder setGastos(float gastos) {
            this.gastos = gastos;
            return this;
        }

        public Builder setAhorros(float ahorros) {
            this.ahorros = ahorros;
            return this;
        }

        public ResumenCuentaDb build() {
            return new ResumenCuentaDb(this);
        }
    }

}
