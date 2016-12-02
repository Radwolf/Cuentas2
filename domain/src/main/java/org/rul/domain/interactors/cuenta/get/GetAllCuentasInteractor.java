package org.rul.domain.interactors.cuenta.get;

import org.rul.domain.interactors.base.Interactor;
import org.rul.domain.model.CuentaDomain;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface GetAllCuentasInteractor extends Interactor {

    void run(Callback<List<CuentaDomain>> callback);

}
