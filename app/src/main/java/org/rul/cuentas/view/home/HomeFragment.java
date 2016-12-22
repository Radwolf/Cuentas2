package org.rul.cuentas.view.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.rul.cuentas.R;
import org.rul.cuentas.view.home.adapater.CuentaAdapter;
import org.rul.cuentas.view.home.adapater.OnCuentaClickedListener;
import org.rul.cuentas.presenters.HomePresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.HomeView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rul on 04/12/2016.
 */

public class HomeFragment extends Fragment implements HomeView, OnCuentaClickedListener {

    @Inject
    HomePresenter homePresenter;

    @Bind(R.id.et_cuenta_nombre)
    EditText etCuentaNombre;

    @Bind(R.id.et_cuenta_saldo)
    EditText etCuentaSaldo;

    @Bind(R.id.rv_cuentas)
    RecyclerView rvCuentas;

    private CuentaAdapter cuentaAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ( ( HomeActivity )getActivity() ).getComponent().inject( this );

        homePresenter.setView( this );
        homePresenter.getAllCuentas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        rvCuentas.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        cuentaAdapter = new CuentaAdapter( this );

        rvCuentas.setAdapter( cuentaAdapter );

        return view;

    }

    @Override
    public void setCuentas(List<Cuenta> cuentasList) {

        cuentaAdapter.setCuentasList( cuentasList );

        cuentaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();

        ButterKnife.unbind(this);

    }

    @OnClick(R.id.bt_insert_cuenta)
    public void onClick() {

        homePresenter.insertCuenta( new Cuenta.Builder()
                .setNombre(etCuentaNombre.getText().toString() )
                .setSaldo(etCuentaSaldo.getText().toString() )
                .build()
        );

    }

    @Override
    public void showGetCuentasError() {

        Snackbar.make( getView(), R.string.error_msg_get_cuentas, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showInsertCuentaError() {

        Snackbar.make( getView(), R.string.error_msg_insert_cuenta, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showRemoveCuentaError() {

        Snackbar.make( getView(), R.string.error_msg_remove_cuenta, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showFieldsNeededError() {

        Snackbar.make( getView(), R.string.error_msg_fields_needed, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onCuentaCliked(Cuenta cuenta) {

        homePresenter.removeCuenta( cuenta );

    }

}