package org.rul.cuentas.interactors.cuenta.remove;

import org.rul.cuentas.interactors.base.BaseInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class RemoveCuentaInteractorImpl extends BaseInteractor implements RemoveCuentaInteractor {

    private CuentaRepository cuentaRepository;

    private CuentaDomain cuentaDomain;

    private Callback<Boolean> callback;


    @Inject
    public RemoveCuentaInteractorImpl(InteractorExecutor interactorExecutor, MainThread mainThread, CuentaRepository cuentaRepository) {
        super(interactorExecutor, mainThread);
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void execute() {

        try {
            cuentaRepository.remove(cuentaDomain);

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
    public void run(CuentaDomain cuentaDomain, Callback<Boolean> callback){

        this.cuentaDomain = cuentaDomain;
        this.callback = callback;
        getInteractorExecutor().executeInteractor( this );

    }

}
