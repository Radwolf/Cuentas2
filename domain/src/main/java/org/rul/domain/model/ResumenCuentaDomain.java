package org.rul.domain.model;

import java.util.Date;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class ResumenCuentaDomain {


    private Date fechaActualizacion;
    private String nombre;
    private float saldo;

    private float ingresos;
    private float gastos;
    private float ahorros;

    private ResumenCuentaDomain(Builder builder) {
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
        this.ingresos = builder.ingresos;
        this.gastos = builder.gastos;
        this.ahorros = builder.ahorros;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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

        private Date fechaActualizacion;
        private String nombre;
        private float saldo;
        private float ingresos;
        private float gastos;
        private float ahorros;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setSaldo(float saldo) {
            this.saldo = saldo;
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

        public Builder setFechaActualizacion(Date fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public ResumenCuentaDomain build(){
            return new ResumenCuentaDomain(this
            );
        }
    }
}
