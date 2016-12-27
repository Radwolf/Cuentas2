package org.rul.cuentas.presenters;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.DashboardView;
import org.rul.cuentas.ui.views.HomeView;

import java.io.InputStream;

/**
 * Created by Rul on 02/12/2016.
 */

public interface DashboardPresenter extends BasePresenter<DashboardView> {

    void onAddNewCuentaClick();

    void showResumenCuentas(String anyoMes);

    void loadDummyData(InputStream is);

    void getAllCuentas();

}
