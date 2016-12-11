package org.rul.cuentas.interactors.cuenta.get;

import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.repository.ResumenCuentaRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class GetActualResumenCuentasInteractorImpl implements GetActualResumenCuentasInteractor {

    private Callback<List<ResumenCuentaDomain>> callback;

    private ResumenCuentaRepository resumenCuentaRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    private String anyoMes;

    @Inject
    public GetActualResumenCuentasInteractorImpl(ResumenCuentaRepository resumenCuentaRepository, MainThread mainThread,
                                                 InteractorExecutor interactorExecutor) {

        this.resumenCuentaRepository = resumenCuentaRepository;
        this.mainThread = mainThread;
        this.interactorExecutor = interactorExecutor;

    }

    @Override
    public void run(String anyoMes, Callback<List<ResumenCuentaDomain>> callback) {

        this.anyoMes = anyoMes;
        this.callback = callback;
        interactorExecutor.executeInteractor( this );

    }

    @Override
    public void execute() {

        mainThread.post(new Runnable() {

            @Override
            public void run() {
                callback.onSuccess( resumenCuentaRepository.findByResumenesActuales(anyoMes) );
            }

        });

    }
}