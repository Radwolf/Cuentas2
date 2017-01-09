package org.rul.cuentas.view.movimiento;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.MovimientosModule;
import org.rul.cuentas.injection.component.DaggerMovimientosComponent;
import org.rul.cuentas.injection.component.MovimientosComponent;
import org.rul.cuentas.view.BaseActivity;
import org.rul.cuentas.view.CuentasApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovimientosActivity extends BaseActivity {

    private MovimientosComponent movimientosComponent;
    private static final String TAG = "DashboardActivity";
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getComponent().inject(this);
        initNavigationDrawer();
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
        return new MovimientosModule();
    }

    public MovimientosComponent getComponent() {
        if (movimientosComponent == null ){

            movimientosComponent = DaggerMovimientosComponent.builder()
                    .applicationComponent( ((CuentasApplication)getApplication()).getApplicationComponent(this) )
                    .activityModule( new ActivityModule( this ) )
                    .build();

        }

        return movimientosComponent;
    }

    @Override
    public void initNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
