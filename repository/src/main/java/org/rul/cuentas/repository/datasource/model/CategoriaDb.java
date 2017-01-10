package org.rul.cuentas.repository.datasource.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rgonzalez on 03/10/2016.
 */

public class CategoriaDb extends RealmObject {

    public static final String K_CATEGORIA_ID = "id";

    @PrimaryKey
    private int id;
    private String nombre;
    //private Categoria categoriaPadre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public Categoria getCategoriaPadre() {
//        return categoriaPadre;
//    }
//
//    public void setCategoriaPadre(Categoria categoriaPadre) {
//        this.categoriaPadre = categoriaPadre;
//    }

    public CategoriaDb() {
    }

    private CategoriaDb (Builder builder){
        this.id = builder.id;
        this.nombre = builder.nombre;
    }

    public static class Builder {

        private int id;
        private String nombre;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public CategoriaDb build() {
            return new CategoriaDb(this);
        }
    }
}
