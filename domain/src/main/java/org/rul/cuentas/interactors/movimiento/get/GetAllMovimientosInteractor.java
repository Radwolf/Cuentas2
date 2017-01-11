package org.rul.cuentas.interactors.movimiento.get;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.MovimientoDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface GetAllMovimientosInteractor extends Interactor {

    void run(boolean conEliminados, Callback<List<MovimientoDomain>> callback);

}
