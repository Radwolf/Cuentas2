package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.Cuenta;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface CuentasView {

    void setCuentas(List<Cuenta> cuentaList);

    void showGetCuentasError();

    void showRemoveCuentaError();

    void showFieldsNeededError();

    class EmptyCuentasView implements CuentasView {

        @Override
        public void setCuentas(List<Cuenta> cuentaList) {

        }

        @Override
        public void showGetCuentasError() {

        }

        @Override
        public void showRemoveCuentaError() {

        }

        @Override
        public void showFieldsNeededError() {

        }
    }

}
