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
    private String nombreCategoria;
    private String idResumenCuenta;
    private String fechaPrevista;
    private String fechaConfirmacion;
    private String fechaBorrado;

    private Movimiento(Builder builder) {
        this.id = builder.id;
        this.descripcion = builder.descripcion;
        this.tipoMovimiento = builder.tipoMovimiento;
        this.ahorro = builder.ahorro;
        this.importe = builder.importe;
        this.importePrevisto = builder.importePrevisto;
        this.idCategoria = builder.idCategoria;
        this.nombreCategoria = builder.nombreCategoria;
        this.idResumenCuenta = builder.idResumenCuenta;
        this.fechaPrevista = builder.fechaPrevista;
        this.fechaConfirmacion = builder.fechaConfirmacion;
        this.fechaBorrado = builder.fechaBorrado;
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

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getIdResumenCuenta() {
        return idResumenCuenta;
    }

    public void setIdResumenCuenta(String idResumenCuenta) {
        this.idResumenCuenta = idResumenCuenta;
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

    public String getFechaBorrado() {
        return fechaBorrado;
    }

    public void setFechaBorrado(String fechaBorrado) {
        this.fechaBorrado = fechaBorrado;
    }

    public static class Builder {

        private String id;
        private String descripcion;
        private String tipoMovimiento;
        private String ahorro;
        private String importe;
        private String importePrevisto;
        private String idCategoria;
        private String nombreCategoria;
        private String idResumenCuenta;
        private String fechaPrevista;
        private String fechaConfirmacion;
        private String fechaBorrado;

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

        public Builder setNombreCategoria(String nombreCategoria){
            this.nombreCategoria = nombreCategoria;
            return this;
        }
        public Builder setIdResumenCuenta(String idResumenCuenta) {
            this.idResumenCuenta = idResumenCuenta;
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

        public Builder setFechaBorrado(String fechaBorrado){
            this.fechaBorrado =  fechaBorrado;
            return this;
        }

        public Movimiento build() {
            return new Movimiento(this);
        }
    }
}