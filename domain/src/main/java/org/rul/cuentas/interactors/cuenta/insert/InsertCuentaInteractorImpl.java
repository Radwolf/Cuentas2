package org.rul.cuentas.interactors.cuenta.insert;

import org.rul.cuentas.interactors.base.BaseInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class InsertCuentaInteractorImpl  extends BaseInteractor implements InsertCuentaInteractor {

    private Callback<CuentaDomain> callback;

    private CuentaDomain cuentaDomain;

    private CuentaRepository cuentaRepository;

    @Inject
    public InsertCuentaInteractorImpl(CuentaRepository cuentaRepository, InteractorExecutor interactorExecutor, MainThread mainThread) {
        super(interactorExecutor, mainThread);
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void run(CuentaDomain cuentaDomain, Callback<CuentaDomain> callback){
        this.cuentaDomain = cuentaDomain;
        this.callback = callback;
        getInteractorExecutor().executeInteractor( this );
    }

    @Override
    public void execute() {

        try{
            final CuentaDomain returnedValue = cuentaRepository.insert(cuentaDomain);

            getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess( returnedValue );
                }

            });

        }catch (final RepositoryException exception){

            getMainThread().post(new Runnable() {
                @Override
                public void run() {
                    callback.onError( exception );
                }
            });

        }

    }
}
