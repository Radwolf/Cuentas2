package org.rul.cuentas.view.dashboard.adapater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.cuentas.R;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.ResumenCuenta;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Rul on 04/12/2016.
 */

public class CardResumenAdapter extends RecyclerView.Adapter<CardResumenAdapter.ResumenCuentaViewHolder> {

    private List<ResumenCuenta> resumenCuentaList;

    private OnCardResumenClickedListener onCardResumenClickedListener;

    public CardResumenAdapter(OnCardResumenClickedListener onCardResumenClickedListener) {
        this.onCardResumenClickedListener = onCardResumenClickedListener;
        this.resumenCuentaList = new ArrayList<>();
    }

    public CardResumenAdapter setResumenCuentasList(List<ResumenCuenta> resumenCuentaList) {
        this.resumenCuentaList = resumenCuentaList;
        return this;
    }

    @Override
    public int getItemCount() {
        return resumenCuentaList.size();
    }

    @Override
    public ResumenCuentaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posicion_general, null);
        return new ResumenCuentaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResumenCuentaViewHolder holder, int position) {
        holder.bind(resumenCuentaList.get(position), onCardResumenClickedListener);
    }


    static class ResumenCuentaViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.titulo_pos_gen)
        TextView tvTituloPosGen;
        @Bind(R.id.saldo_pos_gen)
        TextView tvSaldoPosGen;
        @Bind(R.id.pg_total_ingresos)
        TextView tvTotalIngresos;
        @Bind(R.id.pg_total_gastos)
        TextView tvTotalGastos;
        @Bind(R.id.pg_total_ahorro)
        TextView tvTotalAhorro;

        public ResumenCuentaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind( this, itemView );
        }

        public void bind(final ResumenCuenta resumenCuenta, final OnCardResumenClickedListener onCardResumenClickedListener) {
            tvTituloPosGen.setText(resumenCuenta.getNombreCuenta());
            float saldo = Float.valueOf(resumenCuenta.getIngresos()) - Float.valueOf(resumenCuenta.getGastos());
            tvSaldoPosGen.setText(String.valueOf(saldo));
            tvTotalIngresos.setText(resumenCuenta.getIngresos());
            tvTotalGastos.setText(resumenCuenta.getGastos());
            tvTotalAhorro.setText(resumenCuenta.getAhorros());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardResumenClickedListener.onCardResumenCliked( resumenCuenta );
                }
            });

        }
    }

}