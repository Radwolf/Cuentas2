package org.rul.cuentas.ui.model;

/**
 * Created by Rul on 02/12/2016.
 */

public class ResumenCuenta {

    private String nombreCuenta;
    private String anyoMes;
    private String ingresos;
    private String gastos;
    private String ahorros;
    private String ingresosPrevistos;
    private String gastosPrevistos;
    private String ahorrosPrevistos;


    private ResumenCuenta(Builder builder) {
        this.nombreCuenta = builder.nombreCuenta;
        this.anyoMes = builder.anyoMes;
        this.ingresos = builder.ingresos;
        this.gastos = builder.gastos;
        this.ahorros = builder.ahorros;
        this.ingresosPrevistos = builder.ingresosPrevistos;
        this.gastosPrevistos = builder.gastosPrevistos;
        this.ahorrosPrevistos = builder.ahorrosPrevistos;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getAnyoMes() {
        return anyoMes;
    }

    public void setAnyoMes(String anyoMes) {
        this.anyoMes = anyoMes;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getGastos() {
        return gastos;
    }

    public void setGastos(String gastos) {
        this.gastos = gastos;
    }

    public String getAhorros() {
        return ahorros;
    }

    public void setAhorros(String ahorros) {
        this.ahorros = ahorros;
    }

    public String getIngresosPrevistos() {
        return ingresosPrevistos;
    }

    public void setIngresosPrevistos(String ingresosPrevistos) {
        this.ingresosPrevistos = ingresosPrevistos;
    }

    public String getGastosPrevistos() {
        return gastosPrevistos;
    }

    public void setGastosPrevistos(String gastosPrevistos) {
        this.gastosPrevistos = gastosPrevistos;
    }

    public String getAhorrosPrevistos() {
        return ahorrosPrevistos;
    }

    public void setAhorrosPrevistos(String ahorrosPrevistos) {
        this.ahorrosPrevistos = ahorrosPrevistos;
    }

    public static class Builder {

        private String nombreCuenta;
        private String anyoMes;
        private String ingresos;
        private String gastos;
        private String ahorros;
        private String ingresosPrevistos;
        private String gastosPrevistos;
        private String ahorrosPrevistos;

        public Builder setNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
            return this;
        }

        public Builder setAnyoMes(String anyoMes) {
            this.anyoMes = anyoMes;
            return this;
        }

        public Builder setIngresos(String ingresos) {
            this.ingresos = ingresos;
            return this;
        }

        public Builder setGastos(String gastos) {
            this.gastos = gastos;
            return this;
        }

        public Builder setAhorros(String ahorros) {
            this.ahorros = ahorros;
            return this;
        }

        public Builder setIngresosPrevistos(String ingresosPrevistos) {
            this.ingresosPrevistos = ingresosPrevistos;
            return this;
        }

        public Builder setGastosPrevistos(String gastosPrevistos) {
            this.gastosPrevistos = gastosPrevistos;
            return this;
        }

        public Builder setAhorrosPrevistos(String ahorrosPrevistos) {
            this.ahorrosPrevistos = ahorrosPrevistos;
            return this;
        }

        public ResumenCuenta build() {
            return new ResumenCuenta(this);
        }
    }
}