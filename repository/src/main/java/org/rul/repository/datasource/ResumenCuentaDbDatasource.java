package org.rul.repository.datasource;


import org.rul.repository.datasource.base.DbDatasource;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.model.ResumenCuentaDb;

import java.util.List;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface ResumenCuentaDbDatasource extends DbDatasource<ResumenCuentaDb> {
    List<ResumenCuentaDb> findByResumenesActuales(String anyoMes);
    ResumenCuentaDb findByCuentaMesAnyo(String nombreCuenta, String anyoMes);
    //Siempre se actualiza el último mes registrado
    ResumenCuentaDb updateIngresos(String nombreCuenta, float importe);
    ResumenCuentaDb updateGastos(String nombreCuenta, float importe);
    ResumenCuentaDb updateAhorros(String nombreCuenta, float importe);
}
