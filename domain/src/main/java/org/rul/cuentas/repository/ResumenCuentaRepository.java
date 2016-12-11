package org.rul.cuentas.repository;

import org.rul.cuentas.model.ResumenCuentaDomain;

import java.util.List;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public interface ResumenCuentaRepository extends Repository<ResumenCuentaDomain>{

    List<ResumenCuentaDomain> findByResumenesActuales(String anyoMes);
    ResumenCuentaDomain findByCuentaMesAnyo(String nombreCuenta, String anyoMes);
    //Siempre se actualiza el último mes registrado
    ResumenCuentaDomain updateIngresos(String nombreCuenta, float importe);
    ResumenCuentaDomain updateGastos(String nombreCuenta, float importe);
    ResumenCuentaDomain updateAhorros(String nombreCuenta, float importe);
}
