package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.CuentasModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.injection.component.presenter.CuentasPresenterComponent;
import org.rul.cuentas.injection.component.repository.CuentaRepositoryComponent;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.view.cuenta.CuentasActivity;
import org.rul.cuentas.view.cuenta.CuentasFragment;

import dagger.Component;

/**
 * Created by Rul on 03/12/2016.
 */

@ForActivity
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                ActivityModule.class,
                CuentasModule.class,
        }

)
public interface CuentasComponent extends CuentasPresenterComponent, CuentaRepositoryComponent{

    Activity activityContext();

    void inject(CuentasActivity cuentasActivity);
    void inject(CuentasFragment cuentasFragment);

    GetAllCuentasInteractor getAllCuentasInteractor();
    RemoveCuentaInteractor removeCuentaInteractor();

}