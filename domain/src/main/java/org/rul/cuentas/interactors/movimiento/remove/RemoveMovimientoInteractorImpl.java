package org.rul.cuentas.interactors.movimiento.remove;

import org.rul.cuentas.interactors.base.BaseInteractor;
import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.repository.MovimientoRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class RemoveMovimientoInteractorImpl extends BaseInteractor implements RemoveMovimientoInteractor {

    private MovimientoRepository movimientoRepository;

    private MovimientoDomain movimientoDomain;

    private Callback<Boolean> callback;

    @Inject
    public RemoveMovimientoInteractorImpl(MovimientoRepository movimientoRepository, MainThread mainThread,
                                          InteractorExecutor interactorExecutor) {
        super(interactorExecutor, mainThread);
        this.movimientoRepository = movimientoRepository;

    }


    @Override
    public void execute() {

        try {
            movimientoRepository.remove(movimientoDomain);
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