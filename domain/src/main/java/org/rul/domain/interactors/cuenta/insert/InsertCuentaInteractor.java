package org.rul.domain.interactors.cuenta.insert;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.model.CuentaDomain;

/**
 * Created by Rul on 02/12/2016.
 */

public interface InsertCuentaInteractor extends Interactor {

    void run(CuentaDomain carDomain, Callback<CuentaDomain> callback);

}
