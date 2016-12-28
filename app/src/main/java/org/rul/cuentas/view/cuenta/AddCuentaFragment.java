package org.rul.cuentas.view.cuenta;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.rul.cuentas.R;
import org.rul.cuentas.presenters.AddCuentaPresenter;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.AddCuentaView;
import org.rul.cuentas.view.dashboard.DashboardActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddCuentaFragment extends Fragment implements AddCuentaView {

    private static final String TAG = "DashboardFragment";
    @Bind(R.id.et_cuenta_nombre)
    EditText etCuentaNombre;
    @Bind(R.id.et_cuenta_saldo)
    EditText etCuentaSaldo;

    @Inject
    AddCuentaPresenter addCuentaPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ( (AddCuentaActivity)getActivity() ).getComponent().inject( this );
        addCuentaPresenter.setView( this );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_cuenta, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button_add)
    public void onAddClick() {
        Cuenta cuenta = new Cuenta.Builder()
                .setNombre(etCuentaNombre.getText().toString())
                .setSaldo(etCuentaSaldo.getText().toString()).build();
        addCuentaPresenter.onSaveCuentaClick(cuenta);
    }

    @Override
    public void finish() {

    }

    @Override
    public void showInsertCuentaError() {

    }

    @Override
    public void showDashboardView() {
        startActivity(new Intent(getActivity(), CuentasActivity.class));
    }
}
