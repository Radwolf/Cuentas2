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
//    private Categoria categoria;
//    private CuentaDb cuentaDb;
    private Date fechaPrevista;
    private Date fechaConfirmacion;

}
