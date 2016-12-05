package org.rul.cuentas.view;

import android.app.Application;

import org.rul.cuentas.injection.ApplicationModule;
import org.rul.cuentas.injection.component.ApplicationComponent;
import org.rul.cuentas.injection.component.DaggerApplicationComponent;

/**
 * Created by Rul on 03/12/2016.
 */

public class CuentasApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}