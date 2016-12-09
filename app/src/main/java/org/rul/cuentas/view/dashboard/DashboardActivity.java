package org.rul.cuentas.view.dashboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.component.DaggerDashboardComponent;
import org.rul.cuentas.injection.component.DashboardComponent;
import org.rul.cuentas.view.CuentasApplication;

public class DashboardActivity extends AppCompatActivity {

    DashboardComponent dashboardComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public DashboardComponent getComponent() {
        if (dashboardComponent == null ){

            dashboardComponent = DaggerDashboardComponent.builder()
                    .applicationComponent( ((CuentasApplication)getApplication()).getApplicationComponent() )
                    .activityModule( new ActivityModule( this ) )
                    .build();

        }

        return dashboardComponent;
    }
}
