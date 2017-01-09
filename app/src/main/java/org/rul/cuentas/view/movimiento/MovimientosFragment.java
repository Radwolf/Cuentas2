package org.rul.cuentas.view.movimiento;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rul.cuentas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovimientosFragment extends Fragment {

    public MovimientosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movimientos, container, false);
    }
}
