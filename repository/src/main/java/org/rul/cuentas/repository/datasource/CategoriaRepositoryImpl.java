package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.model.Categoria;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CategoriaRepositoryImpl implements CategoriaRepository {


    @Override
    public void createCategoriaPadre(final String nombre) throws RepositoryException {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        insert(categoria);
    }

    @Override
    public void createCategoriaHija(final String nombre, final Categoria padre) throws RepositoryException {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setCategoriaPadre(padre);
        insert(categoria);
    }

    @Override
    public RealmResults<Categoria> findAll() {
        return Realm.getDefaultInstance().where(Categoria.class).findAll();
    }

    @Override
    public Categoria insert(final Categoria categoria) throws RepositoryException {
        Realm realm = Realm.getDefaultInstance();
        final Categoria[] categorias = {null};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                categorias[0] = realm.createObject(Categoria.class, categoria.getNombre());
                if(categoria.getCategoriaPadre() != null){
                    categorias[0].setCategoriaPadre(categoria.getCategoriaPadre());
                }
            }
        });
        realm.close();
        return categorias[0];
    }

    @Override
    public List<Categoria> insertAll(List<Categoria> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(Categoria element) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public Categoria findByNombre(String nombre) {
        return Realm.getDefaultInstance().where(Categoria.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public RealmResults<Categoria> findCategoriasPadre() {
        return Realm.getDefaultInstance().where(Categoria.class).isEmpty("categoriaPadre").findAll();
    }

    @Override
    public RealmResults<Categoria> findCategoriasHija(Categoria padre) {
        return Realm.getDefaultInstance().where(Categoria.class).equalTo("categoriaPadre.nombre", padre.getNombre()).findAll();
    }
}
