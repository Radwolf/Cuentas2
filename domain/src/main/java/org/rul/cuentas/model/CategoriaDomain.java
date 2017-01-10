package org.rul.cuentas.model;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public class CategoriaDomain {


    private int id;
    private String nombre;

    private CategoriaDomain(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
    }

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

    public static class Builder{

        private int id;
        private String nombre;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public CategoriaDomain build(){
            return new CategoriaDomain(this
            );
        }
    }
}
