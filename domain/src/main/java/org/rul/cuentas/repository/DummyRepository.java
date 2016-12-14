package org.rul.cuentas.repository;

import org.rul.cuentas.model.CuentaDomain;

import java.io.InputStream;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public interface DummyRepository{

    Object load(InputStream is);
}
