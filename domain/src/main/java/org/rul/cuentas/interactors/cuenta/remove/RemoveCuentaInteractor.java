package org.rul.cuentas.interactors.cuenta.remove;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.CuentaDomain;

/**
 * Created by Rul on 02/12/2016.
 */

public interface RemoveCuentaInteractor extends Interactor {

    void run(CuentaDomain cuentaDomain, Callback<Boolean> callback);

}
