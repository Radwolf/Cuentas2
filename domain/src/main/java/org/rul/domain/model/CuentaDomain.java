package org.rul.domain.model;

import java.util.Date;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CuentaDomain {


    private Date fechaActualizacion;
    private String nombre;
    private float saldo;

    private CuentaDomain(Builder builder) {
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
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

    public static class Builder{

        private Date fechaActualizacion;
        private String nombre;
        private float saldo;


        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setSaldo(float saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder setFechaActualizacion(Date fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }


        public CuentaDomain build(){
            return new CuentaDomain(this
            );
        }
    }
}
