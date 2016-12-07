package org.rul.presenter.presenters;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.domain.interactors.cuenta.get.GetResumenCuentasInteractor;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.presenter.mappers.CuentaUiMapper;
import org.rul.presenter.ui.model.Cuenta;
import org.rul.presenter.ui.views.DashboardView;
import org.rul.presenter.ui.views.HomeView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class DashboardPresenterImpl implements DashboardPresenter {

    private DashboardView dashboardView;
    private GetResumenCuentasInteractor getResumenCuentasInteractor;
    private CuentaUiMapper cuentaUiMapper;

    @Inject
    public DashboardPresenterImpl(GetAllCuentasInteractor getAllCuentasInteractor, InsertCuentaInteractor insertCuentaInteractor,
                                  RemoveCuentaInteractor removeCuentaInteractor, CuentaUiMapper cuentaUiMapper) {

        this.getResumenCuentasInteractor = getResumenCuentasInteractor;
        this.cuentaUiMapper = cuentaUiMapper;
    }

    @Override
    public void getResumenCuentas() {

        getResumenCuentasInteractor.run(new Interactor.Callback<List<ResumenCuentaDomain>>() {
            @Override
            public void onSuccess(List<ResumenCuentaDomain> object) {
                dashboardView.setCuentas(cuentaUiMapper.mapList(object));
            }

            @Override
            public void onError(Throwable throwable) {
                dashboardView.showGetCuentasError();
            }
        });


    }

    @Override
    public void setView(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
    }

}
