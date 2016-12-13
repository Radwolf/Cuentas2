package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.HomeModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.view.home.HomeActivity;
import org.rul.cuentas.view.home.HomeFragment;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.presenters.HomePresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.model.CuentaDb;

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
                HomeModule.class,
        }

)
public interface HomeComponent {

    Activity activityContext();

    void inject(HomeActivity homeActivity);

    void inject(HomeFragment homeFragment);

    HomePresenter presenter();

    GetAllCuentasInteractor getAllCuentasInteractor();

    InsertCuentaInteractor insertCuentaInteractor();

    RemoveCuentaInteractor removeCuentaInteractor();

    CuentaRepository cuentaRepository();

    CuentaDbDatasource cuentaDbDatasource();

    Mapper<Cuenta, CuentaDomain> cuentaUiMapper();

    Mapper<CuentaDomain, CuentaDb> cuentaDomainMapper();

}