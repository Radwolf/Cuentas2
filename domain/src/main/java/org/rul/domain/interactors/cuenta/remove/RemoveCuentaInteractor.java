package org.rul.domain.interactors.cuenta.remove;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.model.CuentaDomain;

/**
 * Created by Rul on 02/12/2016.
 */

public interface RemoveCuentaInteractor extends Interactor {

    void run(CuentaDomain cuentaDomain, Callback<Boolean> callback);

}
