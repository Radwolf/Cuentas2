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

    private ResumenCuentaDomain(Builder builder) {
        this.nombreCuenta = builder.nombreCuenta;
        this.anyoMes = builder.anyoMes;
        this.ingresos = builder.ingresos;
        this.gastos = builder.gastos;
        this.ahorros = builder.ahorros;
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

    public static class Builder{

        private String nombreCuenta;
        private String anyoMes;
        private float ingresos;
        private float gastos;
        private float ahorros;

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

        public ResumenCuentaDomain build(){
            return new ResumenCuentaDomain(this
            );
        }
    }
}
