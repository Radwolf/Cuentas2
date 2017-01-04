package org.rul.cuentas.injection.component.presenter;

import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.presenters.AddCuentaPresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.util.Mapper;

/**
 * Created by rgonzalez on 22/12/2016.
 */

public interface AddCuentaPresenterComponent {
    AddCuentaPresenter presenter();
    Mapper<Cuenta, CuentaDomain> cuentaUiMapper();

    InsertCuentaInteractor insertCuentaInteractor();
}
