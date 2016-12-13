package org.rul.cuentas.repository.datasource;

import org.rul.cuentas.repository.model.CuentaDb;
import org.rul.cuentas.repository.providers.RealmProvider;
import org.rul.cuentas.repository.exceptions.RepositoryException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class DummyDbDatasourceImpl implements DummyDbDatasource {

    private RealmProvider realmProvider;

    @Inject
    public DummyDbDatasourceImpl(RealmProvider realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public void loadDummy() {
        try {
            InputStream is = new FileInputStream(new File("cuentas2.json"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        /*getRealm().beginTransaction();
        try {
            getRealm().createAllFromJson(City.class, is);
            getRealm().commitTransaction();
        } catch (IOException e) {
            getRealm().cancelTransaction();
        }*/
    }


    private Realm getRealm() {
        return realmProvider.getDatabase();
    }


    @Override
    public List<CuentaDb> findAll() {
        return null;
    }

    @Override
    public CuentaDb insert(CuentaDb element) throws RepositoryException {
        return null;
    }

    @Override
    public List<CuentaDb> insertAll(List<CuentaDb> elementList) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(CuentaDb element) {

    }

    @Override
    public void removeAll() {

    }
}
