package org.rul.cuentas.presenters;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.HomeView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface HomePresenter {

    void setView(HomeView homeView);

    void getAllCuentas();

    void insertCuenta(Cuenta cuenta);

    void removeCuenta(Cuenta cuenta);
}
