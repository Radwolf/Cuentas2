package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.ResumenCuenta;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface DashboardView {

    void showResumenesCuentas(List<ResumenCuenta> cuentaList);

    void showAddCuentaView();

    void showGetCuentasError();

    void showInsertCuentaError();

    void showRemoveCuentaError();

    void showFieldsNeededError();

    class EmptyDashboardView implements DashboardView {

        @Override
        public void showResumenesCuentas(List<ResumenCuenta> cuentaList) {

        }

        @Override
        public void showAddCuentaView() {

        }

        @Override
        public void showGetCuentasError() {

        }

        @Override
        public void showInsertCuentaError() {

        }

        @Override
        public void showRemoveCuentaError() {

        }

        @Override
        public void showFieldsNeededError() {

        }
    }
}
