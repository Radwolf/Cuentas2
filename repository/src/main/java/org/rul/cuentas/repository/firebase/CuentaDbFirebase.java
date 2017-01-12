package org.rul.cuentas.repository.firebase;


import org.rul.cuentas.repository.firebase.base.DbFirebase;
import org.rul.cuentas.repository.firebase.model.CuentaFb;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CuentaDbFirebase extends DbFirebase<CuentaFb> {
    CuentaFb findByNombre(String nombre);

    void updateSaldo(CuentaFb cuentaDb);
}
