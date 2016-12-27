package org.rul.cuentas.presenters;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.AddCuentaView;

/**
 * Created by Rul on 02/12/2016.
 */

public interface AddCuentaPresenter extends BasePresenter<AddCuentaView> {

    void onSaveCuentaClick(Cuenta cuenta);

}
