package org.rul.cuentas.repository.datasource;


import org.rul.cuentas.repository.datasource.model.CategoriaDb;
import org.rul.cuentas.repository.exceptions.RepositoryException;
import org.rul.cuentas.repository.providers.RealmProvider;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CategoriaDbDatasourceImpl implements CategoriaDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public CategoriaDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public void createCategoriaPadre(final String nombre) throws RepositoryException {
        CategoriaDb categoria = new CategoriaDb();
        categoria.setNombre(nombre);
        insert(categoria);
    }

    @Override
    public void createCategoriaHija(final String nombre, final CategoriaDb padre) throws RepositoryException {
        CategoriaDb categoria = new CategoriaDb();
        categoria.setNombre(nombre);
        //categoria.setCategoriaPadre(padre);
        insert(categoria);
    }

    @Override
    public RealmResults<CategoriaDb> findAll() {
        return getRealm().where(CategoriaDb.class).findAll();
    }

    @Override
    public CategoriaDb insert(final CategoriaDb categoria) throws RepositoryException {
        final CategoriaDb[] categorias = {null};
        getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                categorias[0] = realm.createObject(CategoriaDb.class, categoria.getNombre());
//                if(categoria.getCategoriaPadre() != null){
//                    categorias[0].setCategoriaPadre(categoria.getCategoriaPadre());
//                }
            }
        });
        getRealm().close();
        return categorias[0];
    }

    @Override
    public List<CategoriaDb> insertAll(List<CategoriaDb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CategoriaDb element) {
    }

    @Override
    public void removeAll() {
    }

    @Override
    public CategoriaDb findByNombre(String nombre) {
        return getRealm().where(CategoriaDb.class).equalTo("nombre", nombre).findFirst();
    }

    @Override
    public RealmResults<CategoriaDb> findCategoriasPadre() {
        return getRealm().where(CategoriaDb.class).isEmpty("categoriaPadre").findAll();
    }

    @Override
    public RealmResults<CategoriaDb> findCategoriasHija(CategoriaDb padre) {
        return getRealm().where(CategoriaDb.class).equalTo("categoriaPadre.nombre", padre.getNombre()).findAll();
    }

    private Realm getRealm() {
        return realmProvider.getDatabase();
    }
}
