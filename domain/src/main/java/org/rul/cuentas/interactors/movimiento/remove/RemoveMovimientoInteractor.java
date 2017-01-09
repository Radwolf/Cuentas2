package org.rul.cuentas.interactors.movimiento.remove;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.MovimientoDomain;

/**
 * Created by Rul on 02/12/2016.
 */

public interface RemoveMovimientoInteractor extends Interactor {

    void run(MovimientoDomain movimientoDomain, Callback<Boolean> callback);

}
