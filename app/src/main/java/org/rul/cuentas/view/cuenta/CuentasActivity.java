package org.rul.cuentas.view.cuenta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.CuentasModule;
import org.rul.cuentas.injection.component.CuentasComponent;
import org.rul.cuentas.injection.component.DaggerCuentasComponent;
import org.rul.cuentas.view.BaseActivity;
import org.rul.cuentas.view.CuentasApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CuentasActivity extends BaseActivity {

    private CuentasComponent cuentasComponent;
    private static final String TAG = "DashboardActivity";
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected Object getModule() {
        return new CuentasModule();
    }

    public CuentasComponent getComponent() {
        if (cuentasComponent == null ){

            cuentasComponent = DaggerCuentasComponent.builder()
                    .applicationComponent( ((CuentasApplication)getApplication()).getApplicationComponent(this) )
                    .activityModule( new ActivityModule( this ) )
                    .build();

        }

        return cuentasComponent;
    }
}
