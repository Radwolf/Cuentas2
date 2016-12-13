package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.model.Categoria;
import org.rul.cuentas.repository.Repository;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public interface CategoriaRepository extends Repository<Categoria> {
    void createCategoriaPadre(String nombre) throws RepositoryException;
    void createCategoriaHija(String nombre, Categoria padre) throws RepositoryException;
    Categoria findByNombre(String nombre);
    RealmResults<Categoria> findCategoriasPadre();
    RealmResults<Categoria> findCategoriasHija(Categoria padre);
}
