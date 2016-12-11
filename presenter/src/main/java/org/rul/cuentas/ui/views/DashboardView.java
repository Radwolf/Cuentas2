package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.ResumenCuenta;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface DashboardView {

    void setResumenesCuentas(List<ResumenCuenta> cuentaList);

    void showGetCuentasError();

    void showInsertCuentaError();

    void showRemoveCuentaError();

    void showFieldsNeededError();

}
