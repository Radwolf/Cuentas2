package org.rul.cuentas.view;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import org.rul.cuentas.R;
import org.rul.cuentas.injection.ApplicationModule;
import org.rul.cuentas.injection.component.ApplicationComponent;
import org.rul.cuentas.injection.component.DaggerApplicationComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Rul on 03/12/2016.
 */

public class CuentasApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

    /*public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }*/

    @VisibleForTesting
    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent(Context context) {
        CuentasApplication app = (CuentasApplication) context.getApplicationContext();
        if (app.applicationComponent == null) {
            app.applicationComponent = app.createComponent();
        }
        return app.applicationComponent;
    }

}