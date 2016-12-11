package org.rul.cuentas.presenters;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.HomeView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;
    private GetAllCuentasInteractor getAllCuentasInteractor;
    private InsertCuentaInteractor insertCuentaInteractor;
    private RemoveCuentaInteractor removeCuentaInteractor;
    private CuentaUiMapper cuentaUiMapper;

    @Inject
    public HomePresenterImpl(GetAllCuentasInteractor getAllCuentasInteractor, InsertCuentaInteractor insertCuentaInteractor,
                             RemoveCuentaInteractor removeCuentaInteractor, CuentaUiMapper cuentaUiMapper) {

        this.getAllCuentasInteractor = getAllCuentasInteractor;
        this.insertCuentaInteractor = insertCuentaInteractor;
        this.removeCuentaInteractor = removeCuentaInteractor;
        this.cuentaUiMapper = cuentaUiMapper;
    }

    @Override
    public void getAllCuentas() {
        getAllCuentasInteractor.run(new Interactor.Callback<List<CuentaDomain>>() {
            @Override
            public void onSuccess(List<CuentaDomain> object) {
                homeView.setCuentas(cuentaUiMapper.mapList(object));
            }

            @Override
            public void onError(Throwable throwable) {
                homeView.showGetCuentasError();
            }
        });
    }

    @Override
    public void setView(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void insertCuenta(Cuenta cuenta) {
        if (cuenta.getNombre().isEmpty() || cuenta.getSaldo().isEmpty() ) {
            homeView.showFieldsNeededError();
        } else {
            insertCuentaInteractor.run(cuentaUiMapper.reverseMap(cuenta), new Interactor.Callback<CuentaDomain>() {
                @Override
                public void onSuccess(CuentaDomain object) {
                    getAllCuentas();
                }

                @Override
                public void onError(Throwable throwable) {
                    homeView.showInsertCuentaError();
                }
            });
        }
    }

    @Override
    public void removeCuenta(Cuenta cuenta) {
        removeCuentaInteractor.run(cuentaUiMapper.reverseMap(cuenta), new Interactor.Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean object) {
                getAllCuentas();
            }

            @Override
            public void onError(Throwable throwable) {
                homeView.showRemoveCuentaError();
            }
        });
    }
}
