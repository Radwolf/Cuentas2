package org.rul.cuentas.view.cuenta.adapater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.cuentas.R;
import org.rul.cuentas.ui.model.Cuenta;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Rul on 04/12/2016.
 */

public class CuentaAdapter extends RecyclerView.Adapter<CuentaAdapter.CuentaViewHolder> {

    private List<Cuenta> cuentaList;

    private OnCuentaClickedListener onCuentaClickedListener;

    public CuentaAdapter(OnCuentaClickedListener onCuentaClickedListener) {
        this.onCuentaClickedListener = onCuentaClickedListener;
        this.cuentaList = new ArrayList<>();
    }

    public CuentaAdapter setCuentasList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
        return this;
    }

    @Override
    public int getItemCount() {
        return cuentaList.size();
    }

    @Override
    public CuentaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cuenta, null);
        return new CuentaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CuentaViewHolder holder, int position) {
        holder.bind(cuentaList.get(position), onCuentaClickedListener);
    }


    static class CuentaViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_cuenta_nombre)
        TextView tvCuentaNombre;

        @Bind(R.id.tv_cuenta_saldo)
        TextView tvCuentaSaldo;

        @Bind(R.id.tv_cuenta_saldo_previsto)
        TextView tvCuentaSaldoPrevisto;

        @Bind(R.id.tv_cuenta_fecha_actualizacion)
        TextView tvCuentaFechaActualizacion;

        public CuentaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind( this, itemView );
        }

        public void bind(final Cuenta cuenta, final OnCuentaClickedListener onCuentaClickedListener) {

            tvCuentaNombre.setText( cuenta.getNombre() );
            tvCuentaSaldo.setText( cuenta.getSaldo() );
            tvCuentaSaldoPrevisto.setText(cuenta.getSaldoPrevisto());
            tvCuentaFechaActualizacion.setText( cuenta.getFechaActualizacion() );

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCuentaClickedListener.onCuentaCliked( cuenta );
                }
            });

        }
    }

}