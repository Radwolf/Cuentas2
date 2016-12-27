package org.rul.cuentas.presenters;

public interface BasePresenter<T> {
    void setView(T view);
    void clearView();
    //void closeRealm();
}
