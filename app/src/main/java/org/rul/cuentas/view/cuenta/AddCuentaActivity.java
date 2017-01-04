package org.rul.cuentas.view.cuenta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.AddCuentaModule;
import org.rul.cuentas.injection.component.AddCuentaComponent;
import org.rul.cuentas.injection.component.DaggerAddCuentaComponent;
import org.rul.cuentas.presenters.AddCuentaPresenter;
import org.rul.cuentas.view.BaseActivity;
import org.rul.cuentas.view.CuentasApplication;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddCuentaActivity extends BaseActivity {

    AddCuentaComponent addCuentaComponent;
    @Inject
    AddCuentaPresenter addCuentaPresenter;

    private static final String TAG = "AddCuentaActivity";
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cuenta);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getComponent().inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Object getModule() {
        return new AddCuentaModule();
    }

    public AddCuentaComponent getComponent() {
        if (addCuentaComponent == null ){

            addCuentaComponent = DaggerAddCuentaComponent.builder()
                    .applicationComponent( ((CuentasApplication)getApplication()).getApplicationComponent(this) )
                    .activityModule( new ActivityModule( this ) )
                    .build();

        }

        return addCuentaComponent;
    }

}
