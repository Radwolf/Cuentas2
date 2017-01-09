package org.rul.cuentas.model;

import java.util.Date;

/**
 * Created by rgonzalez on 02/12/2016.
 */
public class MovimientoDomain {

    private int id;
    private String descripcion;
    private String tipoMovimiento;
    private boolean ahorro;
    private float importe;
    private float importePrevisto;
    private int idCategoria;
    private String nombreCategoria;
    private int idResumenCuenta;
    private String fechaPrevista;
    private String fechaConfirmacion;

    private MovimientoDomain(Builder builder) {
        this.id = builder.id;
        this.descripcion = builder.descripcion;
        this.tipoMovimiento = builder.tipoMovimiento;
        this.ahorro = builder.ahorro;
        this.importe = builder.importe;
        this.importePrevisto = builder.importePrevisto;
        this.idCategoria = builder.idCategoria;
        this.nombreCategoria =  builder.nombreCategoria;
        this.idResumenCuenta = builder.idResumenCuenta;
        this.fechaPrevista = builder.fechaPrevista;
        this.fechaConfirmacion = builder.fechaConfirmacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isAhorro() {
        return ahorro;
    }

    public void setAhorro(boolean ahorro) {
        this.ahorro = ahorro;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getImportePrevisto() {
        return importePrevisto;
    }

    public void setImportePrevisto(float importePrevisto) {
        this.importePrevisto = importePrevisto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdResumenCuenta() {
        return idResumenCuenta;
    }

    public void setIdResumenCuenta(int idResumenCuenta) {
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

    public static class Builder{

        private int id;
        private String descripcion;
        private String tipoMovimiento;
        private boolean ahorro;
        private float importe;
        private float importePrevisto;
        private int idCategoria;
        private String nombreCategoria;
        private int idResumenCuenta;
        private String fechaPrevista;
        private String fechaConfirmacion;

        public Builder setId(int id) {
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

        public Builder setAhorro(boolean ahorro) {
            this.ahorro = ahorro;
            return this;
        }

        public Builder setImporte(float importe) {
            this.importe = importe;
            return this;
        }

        public Builder setImportePrevisto(float importePrevisto) {
            this.importePrevisto = importePrevisto;
            return this;
        }

        public Builder setIdCategoria(int idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }

        public Builder setNombreCategoria(String nombreCategoria) {
            this.nombreCategoria = nombreCategoria;
            return this;
        }

        public Builder setIdResumenCuenta(int idResumenCuenta) {
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

        public MovimientoDomain build(){
            return new MovimientoDomain(this
            );
        }
    }
}
