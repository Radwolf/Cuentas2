package org.rul.cuentas.interactors.cuenta.dummy;

import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.DummyRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class LoadDummyDatosInteractorImpl implements LoadDummyDatosInteractor {

    private Callback<Object> callback;

    private DummyRepository dummyRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    @Inject
    public LoadDummyDatosInteractorImpl(DummyRepository dummyRepository, MainThread mainThread,
                                        InteractorExecutor interactorExecutor) {

        this.dummyRepository = dummyRepository;
        this.mainThread = mainThread;
        this.interactorExecutor = interactorExecutor;

    }

    @Override
    public void run(Callback<Object> callback) {

        this.callback = callback;
        interactorExecutor.executeInteractor( this );

    }

    @Override
    public void execute() {

        mainThread.post(new Runnable() {

            @Override
            public void run() {
                callback.onSuccess( dummyRepository.load() );
            }

        });

    }
}