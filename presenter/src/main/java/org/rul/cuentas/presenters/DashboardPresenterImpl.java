package org.rul.cuentas.presenters;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.interactors.cuenta.dummy.LoadDummyDatosInteractor;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.mappers.ResumenCuentaUiMapper;
import org.rul.cuentas.ui.views.DashboardView;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class DashboardPresenterImpl implements DashboardPresenter {

    private DashboardView dashboardView;
    private GetActualResumenCuentasInteractor getActualResumenCuentasInteractor;
    private LoadDummyDatosInteractor loadDummyDatosInteractor;
    private ResumenCuentaUiMapper resumenCuentaUiMapper;

    @Inject
    public DashboardPresenterImpl(GetActualResumenCuentasInteractor getActualResumenCuentasInteractor,
                                  LoadDummyDatosInteractor loadDummyDatosInteractor,
                                  ResumenCuentaUiMapper resumenCuentaUiMapper) {
        this.getActualResumenCuentasInteractor = getActualResumenCuentasInteractor;
        this.loadDummyDatosInteractor = loadDummyDatosInteractor;
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
    public void loadDummyData(InputStream is) {
        loadDummyDatosInteractor.run(is, new Interactor.Callback<Object>(){
            @Override
            public void onSuccess(Object object) {

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
