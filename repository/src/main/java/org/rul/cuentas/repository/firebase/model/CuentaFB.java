package org.rul.cuentas.repository.firebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.firebase.CuentaDbFirebase;

import java.util.Date;

/**
 * Created by rgonzalez on 15/12/2016.
 */

@IgnoreExtraProperties
public class CuentaFb {

    private String nombre;
    private float saldo;
    private String fechaActualizacion;

    public CuentaFb() {
    }

    public CuentaFb(String nombre, float saldo, String fechaActualizacion) {
        this.nombre = nombre;
        this.saldo = saldo;
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

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public CuentaFb (Builder builder){
        this.fechaActualizacion = builder.fechaActualizacion;
        this.nombre = builder.nombre;
        this.saldo = builder.saldo;
    }

    public static class Builder {

        private String fechaActualizacion;
        private String nombre;
        private float saldo;

        public CuentaFb.Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public CuentaFb.Builder setSaldo(float saldo) {
            this.saldo = saldo;
            return this;
        }

        public CuentaFb.Builder setFechaActualizacion(String fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public CuentaFb build() {
            return new CuentaFb(this);
        }
    }
}
