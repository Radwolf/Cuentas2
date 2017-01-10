package org.rul.cuentas.view.movimiento;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rul.cuentas.R;
import org.rul.cuentas.presenters.MovimientosPresenter;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.ui.views.MovimientosView;
import org.rul.cuentas.view.movimiento.adapter.MovimientoAdapter;
import org.rul.cuentas.view.movimiento.adapter.OnMovimientoClickedListener;
import org.rul.cuentas.view.movimiento.adapter.OnMovimientoLongClickedListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovimientosFragment extends Fragment implements MovimientosView, OnMovimientoClickedListener, OnMovimientoLongClickedListener{

    @Bind(R.id.rv_movimientos)
    RecyclerView rvMovimientos;

    private MovimientoAdapter movimientoAdapter;
    @Inject
    MovimientosPresenter movimientosPresenter;

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Remove swiped item from list and notify the RecyclerView

            if (swipeDir == ItemTouchHelper.LEFT) {
                final boolean[] movimientoBorrado = {true};
                final Movimiento movimiento = movimientoAdapter.getItem(viewHolder.getAdapterPosition());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                movimiento.setFechaBorrado(sdf.format(new Date()));
                movimientosPresenter.logicRemoveMovimiento(movimiento);
                Snackbar snackbar = Snackbar
                        .make(rvMovimientos, "Movimiento eliminado", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                movimiento.setFechaBorrado(null);
                                movimientosPresenter.logicRemoveMovimiento(movimiento);
                                Snackbar snackbar1 = Snackbar.make(rvMovimientos, "Movimiento restaurado", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                                movimientosPresenter.showAllMovimientos();
                                movimientoBorrado[0] = false;
                            }
                        });

                snackbar.show();
                //return movimientoBorrado[0];

            } else {
                movimientosPresenter.showAllMovimientos();
            }
        }
    };

    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);

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
        movimientoAdapter = new MovimientoAdapter(this, this);
        rvMovimientos.setAdapter(movimientoAdapter);
        itemTouchHelper.attachToRecyclerView(rvMovimientos);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setMovimientos(List<Movimiento> movimientoList) {
        movimientoAdapter.setMovimientosList(movimientoList);
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
        Snackbar snackbar = Snackbar.make(getView(), "Vamos a confirmar", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public boolean onMovimientoLongCliked(final Movimiento movimiento) {
        return true;
    }

    @Override
    public void confirmDelete(Movimiento movimiento) {
        //movimientosPresenter.removeMovimiento(movimiento);
        //Snackbar snackbar2 = Snackbar.make(getView(), "Movimiento eliminado confirmado", Snackbar.LENGTH_SHORT);
        //snackbar2.show();
    }
}
