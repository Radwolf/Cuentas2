package org.rul.cuentas.injection;

import android.app.Application;

import org.rul.cuentas.thread.ApplicationMainThread;
import org.rul.cuentas.threads.InteractorExecutor;
import org.rul.cuentas.threads.MainThread;
import org.rul.cuentas.threads.ThreadExecutor;
import org.rul.cuentas.providers.DbProvider;
import org.rul.cuentas.providers.RealmProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Rul on 03/12/2016.
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application getApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public MainThread providesMainThread(ApplicationMainThread mainThread) {
        return mainThread;
    }

    @Provides
    @Singleton
    public InteractorExecutor provideThreadExecutor(ThreadExecutor executor) {
        return executor;
    }

    @Provides
    @Singleton
    public DbProvider<Realm> providesDbProvider(RealmProvider realmProvider){

        return realmProvider;

    }

}
