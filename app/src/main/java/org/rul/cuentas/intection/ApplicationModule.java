package org.rul.cuentas.intection;

import android.app.Application;

import org.rul.cuentas.thread.ApplicationMainThread;
import org.rul.domain.threads.InteractorExecutor;
import org.rul.domain.threads.MainThread;
import org.rul.domain.threads.ThreadExecutor;
import org.rul.repository.providers.DbProvider;
import org.rul.repository.providers.RealmProvider;

import javax.inject.Singleton;

import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Rul on 03/12/2016.
 */

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
