package org.rul.cuentas.interactors.movimiento.get;

import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.MovimientoRepository;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class GetAllMovimientosInteractorImpl implements GetAllMovimientosInteractor {

    private Callback<List<MovimientoDomain>> callback;
    private boolean conEliminados;

    private MovimientoRepository movimientoRepository;

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    @Inject
    public GetAllMovimientosInteractorImpl(MovimientoRepository movimientoRepository, MainThread mainThread,
                                           InteractorExecutor interactorExecutor) {

        this.movimientoRepository = movimientoRepository;
        this.mainThread = mainThread;
        this.interactorExecutor = interactorExecutor;

    }

    @Override
    public void run(boolean conEliminados, Callback<List<MovimientoDomain>> callback) {

        this.conEliminados = conEliminados;
        this.callback = callback;
        interactorExecutor.executeInteractor( this );

    }

    @Override
    public void execute() {

        mainThread.post(new Runnable() {

            @Override
            public void run() {
                List<MovimientoDomain> movimientos = new ArrayList<MovimientoDomain>();
                if(conEliminados){
                    movimientos = movimientoRepository.findAll();
                }else {
                    movimientos = movimientoRepository.findAllFechaBorradoIsNull();
                }
                callback.onSuccess(movimientos);
            }

        });

    }
}