package org.rul.cuentas.presenters;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.AddCuentaView;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class AddCuentaPresenterImpl implements AddCuentaPresenter {

    private AddCuentaView addCuentaView = new AddCuentaView.EmptyAddCuentaView();
    private InsertCuentaInteractor insertCuentaInteractor;
    private CuentaUiMapper cuentaUiMapper;

    @Inject
    public AddCuentaPresenterImpl(InsertCuentaInteractor insertCuentaInteractor, CuentaUiMapper cuentaUiMapper) {
        this.insertCuentaInteractor = insertCuentaInteractor;
        this.cuentaUiMapper = cuentaUiMapper;
    }

    @Override
    public void clearView() {
        addCuentaView = new AddCuentaView.EmptyAddCuentaView();
    }

    @Override
    public void onSaveCuentaClick(Cuenta cuenta) {

        //TODO: Comprobar si todos los campos estan rellenos Obligatorios
        /*if (car.getPlateNumber().isEmpty() || car.getBrand().isEmpty() || car.getModel().isEmpty() ) {

            homeView.showFieldsNeededError();

        } else {*/
        insertCuentaInteractor.run(cuentaUiMapper.reverseMap(cuenta), new Interactor.Callback<CuentaDomain>() {
            @Override
            public void onSuccess(CuentaDomain object) {
                //dashboardView.showResumenesCuentas(resumenCuentaUiMapper.mapList(object));
                System.out.println(String.format("Cuenta %s insertadada.", object.getNombre()));
                addCuentaView.showDashboardView();
            }

            @Override
            public void onError(Throwable throwable) {
                addCuentaView.showInsertCuentaError();
            }
        });


    }

    @Override
    public void setView(AddCuentaView addCuentaView) {
        this.addCuentaView = addCuentaView;
    }

}
