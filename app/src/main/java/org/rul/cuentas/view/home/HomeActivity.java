package org.rul.cuentas.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ActivityModule;
import org.rul.cuentas.injection.component.HomeComponent;
import org.rul.cuentas.injection.component.DaggerHomeComponent;
import org.rul.cuentas.view.CuentasApplication;

/**
 * Created by Rul on 04/12/2016.
 */

public class HomeActivity extends AppCompatActivity {

    private HomeComponent homeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

    }

    public HomeComponent getComponent() {
        if (homeComponent == null ){

            homeComponent = DaggerHomeComponent.builder()
                    .applicationComponent( ((CuentasApplication)getApplication()).getApplicationComponent(this) )
                    .activityModule( new ActivityModule( this ) )
                    .build();

        }

        return homeComponent;
    }
}
