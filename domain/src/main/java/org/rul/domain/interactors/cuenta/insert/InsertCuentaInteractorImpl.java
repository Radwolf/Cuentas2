package org.rul.domain.interactors.cuenta.insert;

import org.rul.domain.interactors.base.BaseInteractor;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.domain.threads.InteractorExecutor;
import org.rul.domain.threads.MainThread;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class InsertCuentaInteractorImpl  extends BaseInteractor implements InsertCuentaInteractor {

    private Callback<CuentaDomain> callback;

    private CuentaDomain cuentaDomain;

    private CuentaRepository cuentaRepository;

    @Inject
    public InsertCuentaInteractorImpl(CuentaRepository carRepository, InteractorExecutor interactorExecutor, MainThread mainThread) {
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
