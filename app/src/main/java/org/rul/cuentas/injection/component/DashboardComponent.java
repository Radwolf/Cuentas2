package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.DashboardModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.CuentaRepositoryImpl;
import org.rul.cuentas.repository.DummyRepository;
import org.rul.cuentas.repository.datasource.DummyDbDatasource;
import org.rul.cuentas.repository.firebase.CuentaDbFirebase;
import org.rul.cuentas.repository.firebase.CuentaDbFirebaseImpl;
import org.rul.cuentas.repository.firebase.model.CuentaFb;
import org.rul.cuentas.view.dashboard.DashboardActivity;
import org.rul.cuentas.view.dashboard.DashboardFragment;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.repository.ResumenCuentaRepository;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.ui.model.ResumenCuenta;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.model.ResumenCuentaDb;

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
public interface DashboardComponent {

    Activity activityContext();

    void inject(DashboardActivity dashboardActivity);

    void inject(DashboardFragment dashboardFragment);

    DashboardPresenter presenter();

    GetActualResumenCuentasInteractor getActualResumenCuentasInteractor();

    ResumenCuentaRepository resumenCuentaRepository();
    DummyRepository dummyRepository();
    CuentaRepository cuentaRepository();

    ResumenCuentaDbDatasource resumenCuentaDbDatasource();
    DummyDbDatasource dummyDatasource();
    //CuentaDbFirebase cuentaDbFirebase();

    Mapper<ResumenCuenta, ResumenCuentaDomain> resumenCuentaUiMapper();
    Mapper<CuentaDomain, CuentaFb> cuentaDomainMapperFb();
    Mapper<ResumenCuentaDomain, ResumenCuentaDb> resumenCuentaDomainMapper();






}