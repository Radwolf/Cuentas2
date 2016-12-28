package org.rul.cuentas.view.cuenta;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rul.cuentas.R;
import org.rul.cuentas.presenters.CuentasPresenter;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.views.CuentasView;
import org.rul.cuentas.view.cuenta.adapater.CuentaAdapter;
import org.rul.cuentas.view.cuenta.adapater.OnCuentaClickedListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class CuentasFragment extends Fragment implements CuentasView, OnCuentaClickedListener {

    @Bind(R.id.rv_cuentas)
    RecyclerView rvCuentas;

    private CuentaAdapter cuentaAdapter;
    @Inject
    CuentasPresenter cuentasPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((CuentasActivity)getActivity()).getComponent().inject( this );
        cuentasPresenter.setView( this );
        cuentasPresenter.showAllCuentas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuentas, container, false);
        ButterKnife.bind(this, view);
        rvCuentas.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        cuentaAdapter = new CuentaAdapter( this );
        rvCuentas.setAdapter( cuentaAdapter );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setCuentas(List<Cuenta> cuentasList) {
        cuentaAdapter.setCuentasList( cuentasList );
        cuentaAdapter.notifyDataSetChanged();
    }

    @Override
    public void showGetCuentasError() {
        Snackbar.make( getView(), R.string.error_msg_get_cuentas, Snackbar.LENGTH_SHORT).show();
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
        cuentasPresenter.removeCuenta( cuenta );
    }
}
