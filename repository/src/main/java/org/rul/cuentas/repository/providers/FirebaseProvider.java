package org.rul.cuentas.repository.providers;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class FirebaseProvider implements DbProvider<DatabaseReference> {

    @Inject
    public FirebaseProvider(Application application) {
    }

    @Override
    public DatabaseReference getDatabase() {
        return FirebaseDatabase.getInstance().getReference();
    }

}
