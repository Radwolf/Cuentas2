package org.rul.cuentas.presenters;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.CuentasView;
import org.rul.cuentas.ui.views.HomeView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface CuentasPresenter extends BasePresenter<CuentasView>{

    void showAllCuentas();
    void removeCuenta(Cuenta cuenta);
}
