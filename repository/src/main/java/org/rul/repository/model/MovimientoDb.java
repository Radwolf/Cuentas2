package org.rul.repository.model;

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
    private Categoria categoria;
    private CuentaDb cuentaDb;
    private Date fechaPrevista;
    private Date fechaConfirmacion;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CuentaDb getCuentaDb() {
        return cuentaDb;
    }

    public void setCuentaDb(CuentaDb cuentaDb) {
        this.cuentaDb = cuentaDb;
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
}
