package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.ResumenCuenta;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface AddCuentaView {

    void finish();
    void showInsertCuentaError();

    class EmptyAddCuentaView implements AddCuentaView {

        @Override
        public void finish() {

        }

        @Override
        public void showInsertCuentaError() {

        }
    }
}
