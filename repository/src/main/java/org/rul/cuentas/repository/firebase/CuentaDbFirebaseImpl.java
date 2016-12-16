package org.rul.cuentas.repository.firebase;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.firebase.model.CuentaFb;
import org.rul.cuentas.repository.providers.FirebaseProvider;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CuentaDbFirebaseImpl implements CuentaDbFirebase {

    private String TAG = CuentaDbFirebaseImpl.class.getName();

    private FirebaseProvider firebaseProvider;

    @Inject
    public CuentaDbFirebaseImpl(FirebaseProvider firebaseProvider) {
        this.firebaseProvider = firebaseProvider;
    }

    @Override
    public List<CuentaFb> findAll() {
        final List<CuentaFb> cuentaFbs = new ArrayList<>();

        getFireBase().child("cuenta").addValueEventListener(
            new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get user value
                    CuentaFb cuenta = dataSnapshot.getValue(CuentaFb.class);

                    // [START_EXCLUDE]
                    if (cuenta == null) {
                        // User is null, error out
                        Log.e(TAG, "Cuenta 1 is unexpectedly null");
                    } else {
                        // Write new post
                        cuentaFbs.add(cuenta);
                        Log.d(TAG, cuenta.getNombre() + " " + cuenta.getSaldo() + " " + cuenta.getFechaActualizacion());
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    // [START_EXCLUDE]
                    //setEditingEnabled(true);
                    // [END_EXCLUDE]
                }
            });
        return cuentaFbs;
    }

    @Override
    public CuentaFb insert(CuentaFb element) throws RepositoryException {
        return null;
    }

    @Override
    public List<CuentaFb> insertAll(List<CuentaFb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CuentaFb element) {
    }

    @Override
    public void removeAll() {
    }

    @Override
    public CuentaFb findByNombre(String nombre) {
        return null;
    }

    @Override
    public void updateSaldo(CuentaFb cuenta) {
    }

    private DatabaseReference getFireBase() {
        return firebaseProvider.getDatabase();
    }
}
