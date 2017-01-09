package org.rul.cuentas.ui.model;

import java.util.Date;

/**
 * Created by Rul on 02/12/2016.
 */

public class Movimiento {

    private String id;
    private String descripcion;
    private String tipoMovimiento;
    private String ahorro;
    private String importe;
    private String importePrevisto;
    private String idCategoria;
    private String nombreCuenta;
    private String fechaPrevista;
    private String fechaConfirmacion;

    private Movimiento(Builder builder) {
        this.id = builder.id;
        this.descripcion = builder.descripcion;
        this.tipoMovimiento = builder.tipoMovimiento;
        this.ahorro = builder.ahorro;
        this.importe = builder.importe;
        this.importePrevisto = builder.importePrevisto;
        this.idCategoria = builder.idCategoria;
        this.nombreCuenta = builder.nombreCuenta;
        this.fechaPrevista = builder.fechaPrevista;
        this.fechaConfirmacion = builder.fechaConfirmacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getAhorro() {
        return ahorro;
    }

    public void setAhorro(String ahorro) {
        this.ahorro = ahorro;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getImportePrevisto() {
        return importePrevisto;
    }

    public void setImportePrevisto(String importePrevisto) {
        this.importePrevisto = importePrevisto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getFechaPrevista() {
        return fechaPrevista;
    }

    public void setFechaPrevista(String fechaPrevista) {
        this.fechaPrevista = fechaPrevista;
    }

    public String getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(String fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public static class Builder {

        private String id;
        private String descripcion;
        private String tipoMovimiento;
        private String ahorro;
        private String importe;
        private String importePrevisto;
        private String idCategoria;
        private String nombreCuenta;
        private String fechaPrevista;
        private String fechaConfirmacion;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setTipoMovimiento(String tipoMovimiento) {
            this.tipoMovimiento = tipoMovimiento;
            return this;
        }

        public Builder setAhorro(String ahorro) {
            this.ahorro = ahorro;
            return this;
        }

        public Builder setImporte(String importe) {
            this.importe = importe;
            return this;
        }

        public Builder setImportePrevisto(String importePrevisto) {
            this.importePrevisto = importePrevisto;
            return this;
        }

        public Builder setIdCategoria(String idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }

        public Builder setNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
            return this;
        }

        public Builder setFechaPrevista(String fechaPrevista) {
            this.fechaPrevista = fechaPrevista;
            return this;
        }

        public Builder setFechaConfirmacion(String fechaConfirmacion) {
            this.fechaConfirmacion = fechaConfirmacion;
            return this;
        }

        public Movimiento build() {
            return new Movimiento(this);
        }
    }
}