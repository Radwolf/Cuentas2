package org.rul.cuentas.ui.model;

/**
 * Created by Rul on 02/12/2016.
 */

public class Cuenta {

    private String fechaActualizacion;
    private String nombre;
    private String saldo;
    private String saldoPrevisto;

    private Cuenta(Builder builder) {
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
        this.saldoPrevisto = builder.saldoPrevisto;
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

    public String getSaldoPrevisto() {
        return saldoPrevisto;
    }

    public void setSaldoPrevisto(String saldoPrevisto) {
        this.saldoPrevisto = saldoPrevisto;
    }

    public static class Builder {

        private String fechaActualizacion;
        private String nombre;
        private String saldo;
        private String saldoPrevisto;

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

        public Builder setSaldoPrevisto(String saldoPrevisto) {
            this.saldoPrevisto = saldoPrevisto;
            return this;
        }

        public Cuenta build() {
            return new Cuenta(this);
        }
    }
}