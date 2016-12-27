package org.rul.cuentas.injection.component.presenter;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.ui.model.ResumenCuenta;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface DashboardPresenterComponent {
    DashboardPresenter presenter();
    Mapper<ResumenCuenta, ResumenCuentaDomain> resumenCuentaUiMapper();
}
