package org.rul.cuentas.interactors.cuenta.get;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.ResumenCuentaDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface GetActualResumenCuentasInteractor extends Interactor {

    void run(String anyoMes, Callback<List<ResumenCuentaDomain>> callback);

}
