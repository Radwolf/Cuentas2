package org.rul.cuentas.interactors.movimiento.remove;

import org.rul.cuentas.interactors.base.BaseInteractor;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.repository.MovimientoRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class LogicRemoveMovimientoInteractorImpl extends BaseInteractor implements LogicRemoveMovimientoInteractor {

    private MovimientoRepository movimientoRepository;

    private MovimientoDomain movimientoDomain;

    private Callback<Boolean> callback;

    @Inject
    public LogicRemoveMovimientoInteractorImpl(MovimientoRepository movimientoRepository, MainThread mainThread,
                                               InteractorExecutor interactorExecutor) {
        super(interactorExecutor, mainThread);
        this.movimientoRepository = movimientoRepository;

    }

    @Override
    public void execute() {
        try {
            movimientoRepository.logicRemoveMovimiento(movimientoDomain.getId(), movimientoDomain.getFechaBorrado());
            getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess( true );
                }
            });
        }catch (final Exception e){
            getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    callback.onError( e );
                }
            });

        }
    }

    @Override
    public void run(MovimientoDomain movimientoDomain, Callback<Boolean> callback){

        this.movimientoDomain = movimientoDomain;
        this.callback = callback;
        getInteractorExecutor().executeInteractor( this );

    }
}