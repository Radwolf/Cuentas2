package org.rul.cuentas.repository;

import org.rul.cuentas.model.CuentaDomain;

import java.util.List;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public interface CuentaRepository  extends Repository<CuentaDomain>{
    List<CuentaDomain> findAllFb();
}
