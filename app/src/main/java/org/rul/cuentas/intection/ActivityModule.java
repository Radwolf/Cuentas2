package org.rul.cuentas.intection;

import android.app.Activity;

import org.rul.cuentas.intection.annotations.ForActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 03/12/2016.
 */

@Module
public class ActivityModule {

    private final Activity activityContext;

    public ActivityModule(Activity activityContext) {
        this.activityContext = activityContext;
    }

    @Provides
    @ForActivity
    Activity getActivityContext() {
        return this.activityContext;
    }

}
