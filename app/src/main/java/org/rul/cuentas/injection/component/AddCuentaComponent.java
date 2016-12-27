package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.AddCuentaModule;
import org.rul.cuentas.injection.DashboardModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.injection.component.presenter.AddCuentaPresenterComponent;
import org.rul.cuentas.injection.component.presenter.DashboardPresenterComponent;
import org.rul.cuentas.injection.component.repository.CuentaFirebaseComponent;
import org.rul.cuentas.injection.component.repository.CuentaRepositoryComponent;
import org.rul.cuentas.injection.component.repository.DummyRepositoryComponent;
import org.rul.cuentas.injection.component.repository.ResumenCuentaRepositoryComponent;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasFbInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.view.cuenta.AddCuentaActivity;
import org.rul.cuentas.view.cuenta.AddCuentaFragment;
import org.rul.cuentas.view.dashboard.DashboardActivity;
import org.rul.cuentas.view.dashboard.DashboardFragment;

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
                AddCuentaModule.class,
        }

)
public interface AddCuentaComponent extends AddCuentaPresenterComponent, CuentaRepositoryComponent{

    Activity activityContext();

    void inject(AddCuentaActivity addCuentaActivity);
    void inject(AddCuentaFragment addCuentaFragment);

    InsertCuentaInteractor insertCuentaInteractor();

}