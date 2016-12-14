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
    private float ingresosPrevistos;
    private float gastosPrevistos;
    private float ahorrosPrevistos;

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

    public float getIngresosPrevistos() {
        return ingresosPrevistos;
    }

    public void setIngresosPrevistos(float ingresosPrevistos) {
        this.ingresosPrevistos = ingresosPrevistos;
    }

    public float getGastosPrevistos() {
        return gastosPrevistos;
    }

    public void setGastosPrevistos(float gastosPrevistos) {
        this.gastosPrevistos = gastosPrevistos;
    }

    public float getAhorrosPrevistos() {
        return ahorrosPrevistos;
    }

    public void setAhorrosPrevistos(float ahorrosPrevistos) {
        this.ahorrosPrevistos = ahorrosPrevistos;
    }

    public ResumenCuentaDb() {
    }

    public ResumenCuentaDb(Builder builder){
        this.cuentaDb = builder.cuentaDb;
        this.anyoMes = builder.anyoMes;
        this.ahorros = builder.ahorros;
        this.gastos = builder.gastos;
        this.ingresos = builder.ingresos;
        this.ahorrosPrevistos = builder.ahorrosPrevistos;
        this.gastosPrevistos = builder.gastosPrevistos;
        this.ingresosPrevistos = builder.ingresosPrevistos;
    }

    public static class Builder {

        private CuentaDb cuentaDb;
        private String anyoMes;
        private float ingresos;
        private float gastos;
        private float ahorros;
        private float ingresosPrevistos;
        private float gastosPrevistos;
        private float ahorrosPrevistos;

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

        public Builder setIngresosPrevistos(float ingresosPrevistos) {
            this.ingresosPrevistos = ingresosPrevistos;
            return this;
        }

        public Builder setGastosPrevistos(float gastosPrevistos) {
            this.gastosPrevistos = gastosPrevistos;
            return this;
        }

        public Builder setAhorrosPrevistos(float ahorrosPrevistos) {
            this.ahorrosPrevistos = ahorrosPrevistos;
            return this;
        }

        public ResumenCuentaDb build() {
            return new ResumenCuentaDb(this);
        }
    }

}
