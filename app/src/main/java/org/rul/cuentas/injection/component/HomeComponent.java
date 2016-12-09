package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.HomeModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.view.home.HomeActivity;
import org.rul.cuentas.view.home.HomeFragment;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.util.Mapper;
import org.rul.presenter.presenters.HomePresenter;
import org.rul.presenter.ui.model.Cuenta;
import org.rul.repository.datasource.CuentaDbDatasource;
import org.rul.repository.model.CuentaDb;

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