package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.Repository;
import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CategoriaDbDatasource extends Repository<CategoriaDb> {
    void createCategoriaPadre(String nombre) throws RepositoryException;

    void createCategoriaHija(String nombre, CategoriaDb padre) throws RepositoryException;

    CategoriaDb findByNombre(String nombre);

    RealmResults<CategoriaDb> findCategoriasPadre();

    RealmResults<CategoriaDb> findCategoriasHija(CategoriaDb padre);
}
