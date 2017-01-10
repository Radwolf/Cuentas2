package org.rul.cuentas.repository.datasource.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class MovimientoDb extends RealmObject {

    public static final String K_MOVIMIENTO_ID = "id";

    @PrimaryKey
    private int id;
    private String descripcion;
    private String tipoMovimiento;
    private boolean ahorro;
    private float importe;
    private float importePrevisto;
    private CategoriaDb categoriaDb;
    private ResumenCuentaDb resumenCuentaDb;
    private Date fechaPrevista;
    private Date fechaConfirmacion;
    private Date fechaBorrado;

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

    public CategoriaDb getCategoriaDb() {
        return categoriaDb;
    }

    public void setCategoriaDb(CategoriaDb categoriaDb) {
        this.categoriaDb = categoriaDb;
    }

    public ResumenCuentaDb getResumenCuentaDb() {
        return resumenCuentaDb;
    }

    public void setResumenCuentaDb(ResumenCuentaDb resumenCuentaDb) {
        this.resumenCuentaDb = resumenCuentaDb;
    }

    public Date getFechaPrevista() {
        return fechaPrevista;
    }

    public void setFechaPrevista(Date fechaPrevista) {
        this.fechaPrevista = fechaPrevista;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaBorrado() {
        return fechaBorrado;
    }

    public void setFechaBorrado(Date fechaBorrado) {
        this.fechaBorrado = fechaBorrado;
    }

    public MovimientoDb() {
    }

    private MovimientoDb(Builder builder) {
        this.id = builder.id;
        this.categoriaDb = builder.categoriaDb;
        this.resumenCuentaDb = builder.resumenCuentaDb;
        this.descripcion = builder.descripcion;
        this.fechaConfirmacion = builder.fechaConfirmacion;
        this.fechaPrevista = builder.fechaConfirmacion;
        this.ahorro = builder.ahorro;
        this.importe = builder.importe;
        this.importePrevisto = builder.importePrevisto;
        this.tipoMovimiento = builder.tipoMovimiento;
        this.fechaBorrado = builder.fechaBorrado;
    }

    public static class Builder {

        private int id;
        private String descripcion;
        private String tipoMovimiento;
        private boolean ahorro;
        private float importe;
        private float importePrevisto;
        private CategoriaDb categoriaDb;
        private ResumenCuentaDb resumenCuentaDb;
        private Date fechaPrevista;
        private Date fechaConfirmacion;
        private Date fechaBorrado;

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

        public Builder setCategoriaDb(CategoriaDb categoriaDb) {
            this.categoriaDb = categoriaDb;
            return this;
        }

        public Builder setResumenCuentaDb(ResumenCuentaDb resumenCuentaDb) {
            this.resumenCuentaDb = resumenCuentaDb;
            return this;
        }

        public Builder setFechaPrevista(Date fechaPrevista) {
            this.fechaPrevista = fechaPrevista;
            return this;
        }

        public Builder setFechaConfirmacion(Date fechaConfirmacion) {
            this.fechaConfirmacion = fechaConfirmacion;
            return this;
        }

        public Builder setFechaBorrado(Date fechaBorrado){
            this.fechaBorrado =  fechaBorrado;
            return this;
        }

        public MovimientoDb build() {
            return new MovimientoDb(this);
        }
    }
}
