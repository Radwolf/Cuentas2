package org.rul.cuentas.providers;

import android.app.Application;

import javax.inject.Inject;

import io.realm.BuildConfig;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Rul on 02/12/2016.
 */

public class RealmProvider implements DbProvider<Realm> {

    @Inject
    public RealmProvider(Application application) {

        Realm.init(application);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("cuentas.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }


    @Override
    public Realm getDatabase() {

        return Realm.getDefaultInstance();

    }

}
