package org.rul.cuentas.injection.component;

import android.app.Application;

import org.rul.cuentas.injection.ApplicationModule;
import org.rul.cuentas.view.CuentasApplication;
import org.rul.domain.threads.InteractorExecutor;
import org.rul.domain.threads.MainThread;
import org.rul.repository.providers.DbProvider;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by Rul on 03/12/2016.
 */

@Singleton
@Component(
        modules = ApplicationModule.class

)
public interface ApplicationComponent {

    void inject(CuentasApplication cuentasApplication);

    Application application();

    MainThread mainThread();

    InteractorExecutor interactorExecutor();

    DbProvider<Realm> providesDbProvider();

}