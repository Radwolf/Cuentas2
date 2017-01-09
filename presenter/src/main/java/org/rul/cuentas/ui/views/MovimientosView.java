package org.rul.cuentas.ui.views;

import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;

import java.util.List;

/**
 * Created by Rul on 02/12/2016.
 */

public interface MovimientosView {

    void setMovimientos(List<Movimiento> movimientoList);

    void showGetMovimientosError();

    void showRemoveMovimientoError();

    void showFieldsNeededError();

    class EmptyMovimientosView implements MovimientosView {

        @Override
        public void setMovimientos(List<Movimiento> movimientoList) {

        }

        @Override
        public void showGetMovimientosError() {

        }

        @Override
        public void showRemoveMovimientoError() {

        }

        @Override
        public void showFieldsNeededError() {

        }
    }

}
