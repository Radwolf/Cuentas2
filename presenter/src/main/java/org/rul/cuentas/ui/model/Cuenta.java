package org.rul.cuentas.ui.model;

/**
 * Created by Rul on 02/12/2016.
 */

public class Cuenta {

    private String fechaActualizacion;
    private String nombre;
    private String saldo;

    private Cuenta(Builder builder) {
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public static class Builder {

        private String fechaActualizacion;
        private String nombre;
        private String saldo;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setSaldo(String saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder setFechaActualizacion(String fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public Cuenta build() {
            return new Cuenta(this);
        }
    }
}