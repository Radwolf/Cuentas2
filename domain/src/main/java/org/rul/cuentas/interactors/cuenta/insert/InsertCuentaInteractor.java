package org.rul.cuentas.interactors.cuenta.insert;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.CuentaDomain;

/**
 * Created by Rul on 02/12/2016.
 */

public interface InsertCuentaInteractor extends Interactor {

    void run(CuentaDomain carDomain, Callback<CuentaDomain> callback);

}
