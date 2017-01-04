package org.rul.cuentas.repository.datasource.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaDb extends RealmObject {

    public static final String K_CUENTA_NOMBRE = "nombre";

    @PrimaryKey
    private String nombre;
    private float saldo;
    private float saldoPrevisto;
    private Date fechaActualizacion;

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

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public float getSaldoPrevisto() {
        return saldoPrevisto;
    }

    public void setSaldoPrevisto(float saldoPrevisto) {
        this.saldoPrevisto = saldoPrevisto;
    }

    public CuentaDb() {
    }

    private CuentaDb(Builder builder) {
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
        this.saldoPrevisto = builder.saldoPrevisto;
    }

    public static class Builder {

        private Date fechaActualizacion;
        private String nombre;
        private float saldo;
        private float saldoPrevisto;

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

        public Builder setSaldoPrevisto(float saldoPrevisto) {
            this.saldoPrevisto = saldoPrevisto;
            return this;
        }

        public CuentaDb build() {
            return new CuentaDb(this);
        }
    }
}
