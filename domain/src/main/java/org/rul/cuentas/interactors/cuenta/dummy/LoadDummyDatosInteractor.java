package org.rul.cuentas.interactors.cuenta.dummy;

import org.rul.cuentas.interactors.base.Interactor;
import org.rul.cuentas.model.CuentaDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface LoadDummyDatosInteractor extends Interactor {

    void run(Callback<Object> callback);

}
