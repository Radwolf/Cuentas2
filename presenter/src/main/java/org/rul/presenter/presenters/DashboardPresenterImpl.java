package org.rul.presenter.presenters;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.presenter.mappers.CuentaUiMapper;
import org.rul.presenter.mappers.ResumenCuentaUiMapper;
import org.rul.presenter.ui.views.DashboardView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class DashboardPresenterImpl implements DashboardPresenter {

    private DashboardView dashboardView;
    private GetActualResumenCuentasInteractor getActualResumenCuentasInteractor;
    private ResumenCuentaUiMapper resumenCuentaUiMapper;

    @Inject
    public DashboardPresenterImpl(GetActualResumenCuentasInteractor getActualResumenCuentasInteractor,
                                  ResumenCuentaUiMapper resumenCuentaUiMapper) {
        this.getActualResumenCuentasInteractor = getActualResumenCuentasInteractor;
        this.resumenCuentaUiMapper = resumenCuentaUiMapper;
    }

    @Override
    public void getResumenCuentas(String anyoMes) {

        getActualResumenCuentasInteractor.run(anyoMes, new Interactor.Callback<List<ResumenCuentaDomain>>() {
            @Override
            public void onSuccess(List<ResumenCuentaDomain> object) {
                dashboardView.setResumenesCuentas(resumenCuentaUiMapper.mapList(object));
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
