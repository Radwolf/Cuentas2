package org.rul.repository.datasource;



import org.rul.domain.repository.Repository;
import org.rul.domain.repository.exceptions.RepositoryException;
import org.rul.repository.model.Categoria;

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
