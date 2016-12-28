package org.rul.cuentas.presenters;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.CuentasView;
import org.rul.cuentas.ui.views.HomeView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class CuentasPresenterImpl implements CuentasPresenter {

    private CuentasView cuentasView = new CuentasView.EmptyCuentasView();
    private GetAllCuentasInteractor getAllCuentasInteractor;
    private RemoveCuentaInteractor removeCuentaInteractor;
    private CuentaUiMapper cuentaUiMapper;

    @Inject
    public CuentasPresenterImpl(GetAllCuentasInteractor getAllCuentasInteractor, RemoveCuentaInteractor removeCuentaInteractor, CuentaUiMapper cuentaUiMapper) {

        this.getAllCuentasInteractor = getAllCuentasInteractor;
        this.removeCuentaInteractor = removeCuentaInteractor;
        this.cuentaUiMapper = cuentaUiMapper;
    }

    @Override
    public void showAllCuentas() {
        getAllCuentasInteractor.run(new Interactor.Callback<List<CuentaDomain>>() {
            @Override
            public void onSuccess(List<CuentaDomain> object) {
                cuentasView.setCuentas(cuentaUiMapper.mapList(object));
            }

            @Override
            public void onError(Throwable throwable) {
                cuentasView.showGetCuentasError();
            }
        });
    }

    @Override
    public void setView(CuentasView cuentasView) {
        this.cuentasView = cuentasView;
    }

    @Override
    public void clearView() {
        cuentasView = new CuentasView.EmptyCuentasView();
    }


    @Override
    public void removeCuenta(Cuenta cuenta) {
        removeCuentaInteractor.run(cuentaUiMapper.reverseMap(cuenta), new Interactor.Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean object) {
                showAllCuentas();
            }

            @Override
            public void onError(Throwable throwable) {
                cuentasView.showRemoveCuentaError();
            }
        });
    }
}
