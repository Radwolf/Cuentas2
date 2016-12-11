package org.rul.cuentas.interactors.cuenta.get;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.CuentaDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface GetAllCuentasInteractor extends Interactor {

    void run(Callback<List<CuentaDomain>> callback);

}
