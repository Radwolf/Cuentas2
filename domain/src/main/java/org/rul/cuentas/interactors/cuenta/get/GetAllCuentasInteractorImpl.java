package org.rul.cuentas.interactors.cuenta.get;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class GetAllCuentasInteractorImpl implements GetAllCuentasInteractor {

    private Callback<List<CuentaDomain>> callback;

    private CuentaRepository cuentaRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    @Inject
    public GetAllCuentasInteractorImpl(CuentaRepository cuentaRepository, MainThread mainThread,
                                    InteractorExecutor interactorExecutor) {

        this.cuentaRepository = cuentaRepository;
        this.mainThread = mainThread;
        this.interactorExecutor = interactorExecutor;

    }

    @Override
    public void run(Callback<List<CuentaDomain>> callback) {

        this.callback = callback;
        interactorExecutor.executeInteractor( this );

    }

    @Override
    public void execute() {

        mainThread.post(new Runnable() {

            @Override
            public void run() {
                //callback.onSuccess( cuentaRepository.findAll() );
                callback.onSuccess( cuentaRepository.findAllFb() );
            }

        });

    }
}