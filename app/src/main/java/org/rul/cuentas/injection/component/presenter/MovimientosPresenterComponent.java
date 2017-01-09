package org.rul.cuentas.injection.component.presenter;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.presenters.CuentasPresenter;
import org.rul.cuentas.presenters.MovimientosPresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface MovimientosPresenterComponent {
    MovimientosPresenter presenter();
    Mapper<Movimiento, MovimientoDomain> movimientoUiMapper();
}
