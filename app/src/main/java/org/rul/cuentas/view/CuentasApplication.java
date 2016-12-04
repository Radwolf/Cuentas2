package org.rul.cuentas.view;

import android.app.Application;

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

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}