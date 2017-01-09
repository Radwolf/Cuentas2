package org.rul.cuentas.presenters;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.interactors.movimiento.get.GetAllMovimientosInteractor;
import org.rul.cuentas.interactors.movimiento.remove.RemoveMovimientoInteractor;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.mappers.MovimientoUiMapper;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.ui.views.CuentasView;
import org.rul.cuentas.ui.views.MovimientosView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class MovimientosPresenterImpl implements MovimientosPresenter {

    private MovimientosView movimientosView = new MovimientosView.EmptyMovimientosView();
    private GetAllMovimientosInteractor getAllMovimientosInteractor;
    private RemoveMovimientoInteractor removeMovimientoInteractor;
    private MovimientoUiMapper movimientoUiMapper;

    @Inject
    public MovimientosPresenterImpl(GetAllMovimientosInteractor getAllMovimientosInteractor, RemoveMovimientoInteractor removeMovimientoInteractor, MovimientoUiMapper movimientoUiMapper) {

        this.getAllMovimientosInteractor = getAllMovimientosInteractor;
        this.removeMovimientoInteractor = removeMovimientoInteractor;
        this.movimientoUiMapper = movimientoUiMapper;
    }

    @Override
    public void showAllMovimientos() {
        getAllMovimientosInteractor.run(new Interactor.Callback<List<MovimientoDomain>>() {
            @Override
            public void onSuccess(List<MovimientoDomain> object) {
                movimientosView.setMovimientos(movimientoUiMapper.mapList(object));
            }

            @Override
            public void onError(Throwable throwable) {
                movimientosView.showGetMovimientosError();
            }
        });
    }

    @Override
    public void setView(MovimientosView movimientosView) {
        this.movimientosView = movimientosView;
    }

    @Override
    public void clearView() {
        movimientosView = new MovimientosView.EmptyMovimientosView();
    }


    @Override
    public void removeMovimiento(Movimiento movimiento) {
        removeMovimientoInteractor.run(movimientoUiMapper.reverseMap(movimiento), new Interactor.Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean object) {
                showAllMovimientos();
            }

            @Override
            public void onError(Throwable throwable) {
                movimientosView.showRemoveMovimientoError();
            }
        });
    }
}
