package org.rul.cuentas.view.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.cuentas.R;
import org.rul.cuentas.view.home.HomeActivity;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.ui.model.ResumenCuenta;
import org.rul.cuentas.ui.views.DashboardView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rgonzalez on 07/12/2016.
 */
public class DashboardFragment extends Fragment implements DashboardView {

    @Inject
    DashboardPresenter dashboardPresenter;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ( (DashboardActivity)getActivity() ).getComponent().inject( this );

        dashboardPresenter.setView( this );
        dashboardPresenter.getResumenCuentas("201610");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setResumenesCuentas(List<ResumenCuenta> cuentaList) {
        if(cuentaList.size() > 0){
            tvTituloPosGen.setText(cuentaList.get(0).getNombreCuenta());
            float saldo = Float.valueOf(cuentaList.get(0).getIngresos()) - Float.valueOf(cuentaList.get(0).getGastos());
            tvSaldoPosGen.setText(String.valueOf(saldo));
            tvTotalIngresos.setText(cuentaList.get(0).getIngresos());
            tvTotalGastos.setText(cuentaList.get(0).getGastos());
            tvTotalAhorro.setText(cuentaList.get(0).getAhorros());
        }
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