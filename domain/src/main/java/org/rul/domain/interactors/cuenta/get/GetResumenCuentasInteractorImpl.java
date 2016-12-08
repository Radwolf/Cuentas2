package org.rul.domain.interactors.cuenta.get;

import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.threads.InteractorExecutor;
import org.rul.domain.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class GetResumenCuentasInteractorImpl implements GetResumenCuentasInteractor {

    private Callback<List<ResumenCuentaDomain>> callback;

    private CuentaRepository cuentaRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    @Inject
    public GetResumenCuentasInteractorImpl(CuentaRepository cuentaRepository, MainThread mainThread,
                                           InteractorExecutor interactorExecutor) {

        this.cuentaRepository = cuentaRepository;
        this.mainThread = mainThread;
        this.interactorExecutor = interactorExecutor;

    }

    @Override
    public void run(Callback<List<ResumenCuentaDomain>> callback) {

        this.callback = callback;
        interactorExecutor.executeInteractor( this );

    }

    @Override
    public void execute() {

        mainThread.post(new Runnable() {

            @Override
            public void run() {
                callback.onSuccess( cuentaRepository.findAll() );
            }

        });

    }
}