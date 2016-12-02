package org.rul.repository.providers;

import android.app.Application;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Rul on 02/12/2016.
 */

public class RealmProvider implements DbProvider<Realm> {

    @Inject
    public RealmProvider(Application application) {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(application)
                .name("cuentas.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }


    @Override
    public Realm getDatabase() {

        return Realm.getDefaultInstance();

    }

}
