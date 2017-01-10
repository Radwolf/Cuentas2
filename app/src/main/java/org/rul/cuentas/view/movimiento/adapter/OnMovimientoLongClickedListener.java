package org.rul.cuentas.view.movimiento.adapter;

import org.rul.cuentas.ui.model.Movimiento;

/**
 * Created by Rul on 04/12/2016.
 */

public interface OnMovimientoLongClickedListener {

    boolean onMovimientoLongCliked(Movimiento movimiento);
    void confirmDelete(Movimiento movimiento);

}
