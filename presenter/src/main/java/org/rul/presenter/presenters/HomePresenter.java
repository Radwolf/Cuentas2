package org.rul.presenter.presenters;

import org.rul.presenter.ui.model.Cuenta;
import org.rul.presenter.ui.views.HomeView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface HomePresenter {

    void setView(HomeView homeView);

    void getAllCuentas();

    void insertCuenta(Cuenta cuenta);

    void removeCuenta(Cuenta cuenta);
}
