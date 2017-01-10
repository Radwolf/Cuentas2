package org.rul.cuentas.view.movimiento.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.cuentas.R;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.view.cuenta.adapater.OnCuentaClickedListener;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Rul on 04/12/2016.
 */

public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.MovimientoViewHolder> {

    private List<Movimiento> movimientoList;

    private OnMovimientoClickedListener onMovimientoClickedListener;
    private OnMovimientoLongClickedListener onMovimientoLongClickedListener;

    public MovimientoAdapter(OnMovimientoClickedListener onMovimientoClickedListener,
                             OnMovimientoLongClickedListener onMovimientoLongClickedListener) {
        this.onMovimientoClickedListener = onMovimientoClickedListener;
        this.onMovimientoLongClickedListener = onMovimientoLongClickedListener;
        this.movimientoList = new ArrayList<>();
    }

    public MovimientoAdapter setMovimientosList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
        return this;
    }

    @Override
    public int getItemCount() {
        return movimientoList.size();
    }

    public Movimiento getItem(int position){
        return movimientoList.get(position);
    }

    @Override
    public MovimientoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movimiento, null);
        return new MovimientoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovimientoViewHolder holder, int position) {
        holder.bind(movimientoList.get(position), onMovimientoClickedListener, onMovimientoLongClickedListener);
    }


    static class MovimientoViewHolder extends RecyclerView.ViewHolder {
        private SimpleDateFormat sdf;

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
            this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        }

        public void bind(final Movimiento movimiento, final OnMovimientoClickedListener onMovimientoClickedListener,
                         final OnMovimientoLongClickedListener onMovimientoLongClickedListener) {

            tvMvDescripcion.setText( movimiento.getDescripcion() );
            tvMvCategoria.setText( movimiento.getNombreCategoria() );
            String fecha = "Sin fecha";
            double importe = 0.0;
            if(movimiento.getImportePrevisto() != null && Double.parseDouble(movimiento.getImportePrevisto()) != 0) {
                importe = Double.parseDouble(movimiento.getImportePrevisto());
                fecha = (movimiento.getFechaPrevista()!=null)?movimiento.getFechaPrevista():movimiento.getFechaConfirmacion();
                try {
                    Calendar calendarActual = Calendar.getInstance();
                    Calendar calendarFechaMovimiento = Calendar.getInstance();
                    calendarFechaMovimiento.setTime(sdf.parse(fecha));
                    if(calendarFechaMovimiento.after(calendarActual)){
                        tvMvFecha.setTextColor(Color.RED);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                importe = Double.parseDouble(movimiento.getImporte());
                fecha = movimiento.getFechaConfirmacion();
            }
            if("GASTO".equals(movimiento.getTipoMovimiento())){
                tvMvImporte.setTextColor(Color.RED);
                importe *= -1;
            }else if("AHORRO".equals(movimiento.getTipoMovimiento())){
                tvMvImporte.setTextColor(Color.BLUE);
            }

            tvMvFecha.setText(fecha);
            tvMvImporte.setText(String.valueOf(importe));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMovimientoClickedListener.onMovimientoCliked( movimiento );
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    boolean confirmDelete = onMovimientoLongClickedListener.onMovimientoLongCliked(movimiento);
                    if(confirmDelete){
                        onMovimientoLongClickedListener.confirmDelete(movimiento);
                    }
                    return confirmDelete;
                }
            });

        }
    }

}