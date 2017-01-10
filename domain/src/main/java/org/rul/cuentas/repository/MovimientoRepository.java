package org.rul.cuentas.repository;

import org.rul.cuentas.model.MovimientoDomain;

import java.util.Date;
import java.util.List;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public interface MovimientoRepository extends Repository<MovimientoDomain>{

    List<MovimientoDomain> findAllFechaBorradoIsNull();
    void logicRemoveMovimiento(int id, Date fechaBorrado);

}
