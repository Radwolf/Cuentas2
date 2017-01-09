package org.rul.cuentas.injection.component;

import android.app.Activity;

import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.CuentasModule;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.injection.component.presenter.CuentasPresenterComponent;
import org.rul.cuentas.injection.component.presenter.MovimientosPresenterComponent;
import org.rul.cuentas.injection.component.repository.CuentaRepositoryComponent;
import org.rul.cuentas.injection.component.repository.MovimientoRepositoryComponent;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.interactors.movimiento.get.GetAllMovimientosInteractor;
import org.rul.cuentas.interactors.movimiento.remove.RemoveMovimientoInteractor;
import org.rul.cuentas.view.cuenta.CuentasActivity;
import org.rul.cuentas.view.cuenta.CuentasFragment;
import org.rul.cuentas.view.movimiento.MovimientosActivity;
import org.rul.cuentas.view.movimiento.MovimientosFragment;

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
public interface MovimientosComponent extends MovimientosPresenterComponent, MovimientoRepositoryComponent {

    Activity activityContext();

    void inject(MovimientosActivity movimientosActivity);
    void inject(MovimientosFragment movimientosFragment);

    GetAllMovimientosInteractor getAllMovimientosInteractor();
    RemoveMovimientoInteractor removeMovimientoInteractor();

}