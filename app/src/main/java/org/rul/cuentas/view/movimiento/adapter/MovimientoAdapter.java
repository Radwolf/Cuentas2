package org.rul.cuentas.view.movimiento.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.cuentas.R;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.view.cuenta.adapater.OnCuentaClickedListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Rul on 04/12/2016.
 */

public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.MovimientoViewHolder> {

    private List<Movimiento> movimientoList;

    private OnMovimientoClickedListener onMovimientoClickedListener;

    public MovimientoAdapter(OnMovimientoClickedListener onMovimientoClickedListener) {
        this.onMovimientoClickedListener = onMovimientoClickedListener;
        this.movimientoList = new ArrayList<>();
    }

    public MovimientoAdapter setCuentasList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
        return this;
    }

    @Override
    public int getItemCount() {
        return movimientoList.size();
    }

    @Override
    public MovimientoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movimiento, null);
        return new MovimientoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovimientoViewHolder holder, int position) {
        holder.bind(movimientoList.get(position), onMovimientoClickedListener);
    }


    static class MovimientoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_mv_descripcion)
        TextView tvMvDescripcion;

        @Bind(R.id.tv_mv_categoria)
        TextView tvMvCategoria;

        @Bind(R.id.tv_mv_fecha)
        TextView tvMvFecha;

        @Bind(R.id.tv_mv_importe)
        TextView tvMvImporte;

        public MovimientoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind( this, itemView );
        }

        public void bind(final Movimiento movimiento, final OnMovimientoClickedListener onMovimientoClickedListener) {

            tvMvDescripcion.setText( movimiento.getDescripcion() );
            tvMvCategoria.setText( movimiento.getIdCategoria() );
            tvMvFecha.setText(movimiento.getFechaConfirmacion());
            tvMvImporte.setText( movimiento.getImporte() );

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMovimientoClickedListener.onMovimientoCliked( movimiento );
                }
            });

        }
    }

}