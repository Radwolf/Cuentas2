package org.rul.cuentas.view.movimiento;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rul.cuentas.R;
import org.rul.cuentas.presenters.MovimientosPresenter;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.ui.views.MovimientosView;
import org.rul.cuentas.view.movimiento.adapter.MovimientoAdapter;
import org.rul.cuentas.view.movimiento.adapter.OnMovimientoClickedListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovimientosFragment extends Fragment implements MovimientosView, OnMovimientoClickedListener {

    @Bind(R.id.rv_movimientos)
    RecyclerView rvMovimientos;

    private MovimientoAdapter movimientoAdapter;
    @Inject
    MovimientosPresenter movimientosPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MovimientosActivity)getActivity()).getComponent().inject( this );
        movimientosPresenter.setView( this );
        movimientosPresenter.showAllMovimientos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movimientos, container, false);
        ButterKnife.bind(this, view);
        rvMovimientos.setLayoutManager(new LinearLayoutManager(getActivity()));
        movimientoAdapter = new MovimientoAdapter(this);
        rvMovimientos.setAdapter(movimientoAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setMovimientos(List<Movimiento> movimientoList) {
        movimientoAdapter.setCuentasList(movimientoList);
        movimientoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showGetMovimientosError() {
        Snackbar.make(getView(), R.string.error_msg_get_cuentas, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showRemoveMovimientoError() {
        Snackbar.make(getView(), R.string.error_msg_remove_cuenta, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showFieldsNeededError() {
        Snackbar.make(getView(), R.string.error_msg_fields_needed, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onMovimientoCliked(Movimiento movimiento) {
        movimientosPresenter.removeMovimiento(movimiento);
    }
}
