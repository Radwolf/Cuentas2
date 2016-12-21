package org.rul.cuentas.interactors.cuenta.get;

import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaFbRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class GetAllCuentasFbInteractorImpl implements GetAllCuentasFbInteractor {

    private Callback<List<CuentaDomain>> callback;

    private CuentaFbRepository cuentaFbRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    @Inject
    public GetAllCuentasFbInteractorImpl(CuentaFbRepository cuentaFbRepository, MainThread mainThread,
                                         InteractorExecutor interactorExecutor) {

        this.cuentaFbRepository = cuentaFbRepository;
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
                callback.onSuccess( cuentaFbRepository.findAll() );
            }

        });

    }
}