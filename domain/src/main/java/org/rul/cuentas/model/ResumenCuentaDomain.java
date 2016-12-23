package org.rul.cuentas.model;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class ResumenCuentaDomain {


    private String nombreCuenta;
    private String anyoMes;
    private float ingresos;
    private float gastos;
    private float ahorros;
    private float ingresosPrevistos;
    private float gastosPrevistos;
    private float ahorrosPrevistos;


    private ResumenCuentaDomain(Builder builder) {
        this.nombreCuenta = builder.nombreCuenta;
        this.anyoMes = builder.anyoMes;
        this.ingresos = builder.ingresos;
        this.gastos = builder.gastos;
        this.ahorros = builder.ahorros;
        this.ingresosPrevistos = builder.ingresosPrevistos;
        this.gastosPrevistos = gastosPrevistos;
        this.ahorrosPrevistos = ahorrosPrevistos;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
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

    public static class Builder{

        private String nombreCuenta;
        private String anyoMes;
        private float ingresos;
        private float gastos;
        private float ahorros;
        private float ingresosPrevistos;
        private float gastosPrevistos;
        private float ahorrosPrevistos;


        public Builder setNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
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

        public ResumenCuentaDomain build(){
            return new ResumenCuentaDomain(this
            );
        }
    }
}
