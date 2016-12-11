package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.Cuenta;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface HomeView {

    void setCuentas( List<Cuenta> cuentaList );

    void showGetCuentasError();

    void showInsertCuentaError();

    void showRemoveCuentaError();

    void showFieldsNeededError();

}
