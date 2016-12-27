package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.DashboardModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.injection.component.repository.ResumenCuentaRepositoryComponent;
import org.rul.cuentas.injection.component.repository.CuentaFirebaseComponent;
import org.rul.cuentas.injection.component.presenter.DashboardPresenterComponent;
import org.rul.cuentas.injection.component.repository.DummyRepositoryComponent;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasFbInteractor;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.view.dashboard.DashboardActivity;
import org.rul.cuentas.view.dashboard.DashboardFragment;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;

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
                DashboardModule.class,
        }

)
public interface DashboardComponent extends DashboardPresenterComponent, ResumenCuentaRepositoryComponent,
        CuentaFirebaseComponent, DummyRepositoryComponent{

    Activity activityContext();

    void inject(DashboardActivity dashboardActivity);
    void inject(DashboardFragment dashboardFragment);

    GetActualResumenCuentasInteractor getActualResumenCuentasInteractor();
    GetAllCuentasFbInteractor getAllCuentasFbInteractor();

}