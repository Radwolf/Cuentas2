package org.rul.presenter.presenters;

import org.rul.presenter.ui.model.Cuenta;
import org.rul.presenter.ui.views.DashboardView;
import org.rul.presenter.ui.views.HomeView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface DashboardPresenter {

    void setView(DashboardView dashboardView);

    void getResumenCuentas();

    //void insertCuenta(Cuenta cuenta);

    //void removeCuenta(Cuenta cuenta);
}
