package org.rul.cuentas.view.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.rul.cuentas.R;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.ui.model.ResumenCuenta;
import org.rul.cuentas.ui.views.DashboardView;
import org.rul.cuentas.view.cuenta.AddCuentaActivity;
import org.rul.cuentas.view.cuenta.AddCuentaFragment;
import org.rul.cuentas.view.dashboard.adapater.CardResumenAdapter;
import org.rul.cuentas.view.dashboard.adapater.OnCardResumenClickedListener;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rgonzalez on 07/12/2016.
 */
public class DashboardFragment extends Fragment implements DashboardView, OnCardResumenClickedListener {

    private static final String TAG = "DashboardFragment";

    @Inject
    DashboardPresenter dashboardPresenter;
    @Bind(R.id.rv_posicion_cuentas)
    RecyclerView rvPosicionCuentas;

    private CardResumenAdapter cardResumenAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ( (DashboardActivity)getActivity() ).getComponent().inject( this );

        dashboardPresenter.setView( this );
        InputStream is = getResources().openRawResource(R.raw.cuentas2);
        dashboardPresenter.loadDummyData(is);
        dashboardPresenter.showResumenCuentas("201701");
        //dashboardPresenter.getAllCuentas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        rvPosicionCuentas.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        cardResumenAdapter = new CardResumenAdapter( this );
        rvPosicionCuentas.setAdapter( cardResumenAdapter );

        return view;
    }

    @Override
    public void showResumenesCuentas(List<ResumenCuenta> resumenCuentaList) {
        cardResumenAdapter.setResumenCuentasList( resumenCuentaList );

        cardResumenAdapter.notifyDataSetChanged();
    }

    @Override
    public void showAddCuentaView() {
        startActivity(new Intent(getActivity(), AddCuentaActivity.class));
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

    @Override
    public void onCardResumenCliked(ResumenCuenta resumenCuenta) {
        Toast.makeText(getActivity(), "He clicado", Toast.LENGTH_SHORT);
    }


}
