package org.rul.domain.interactors.cuenta.get;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface GetResumenCuentasInteractor extends Interactor {

    void run(Callback<List<ResumenCuentaDomain>> callback);

}
