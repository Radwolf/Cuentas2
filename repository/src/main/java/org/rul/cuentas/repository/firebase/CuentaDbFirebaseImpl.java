package org.rul.cuentas.repository.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.firebase.model.CuentaFb;
import org.rul.cuentas.repository.providers.FirebaseProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
                        List<CuentaFb> cuentas = (List<CuentaFb>) dataSnapshot.getValue();

                        // [START_EXCLUDE]
                        if (cuentas == null) {
                            // User is null, error out
                            Log.e(TAG, "Cuenta 1 is unexpectedly null");
                        } else {
                            // Write new post
                            cuentaFbs.addAll(cuentas);
                            //Log.d(TAG, cuentas.get(0).getNombre() + " " + cuentas.get(0).getSaldo() + " " + cuentas.get(0).getFechaActualizacion());
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
