package org.rul.cuentas.presenters;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.ui.views.CuentasView;
import org.rul.cuentas.ui.views.MovimientosView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface MovimientosPresenter extends BasePresenter<MovimientosView>{

    void showAllMovimientos();
    void removeMovimiento(Movimiento movimiento);
}
