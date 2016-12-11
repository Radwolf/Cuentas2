package org.rul.cuentas.threads;

/**
 * Created by Rul on 02/12/2016.
 */

public interface MainThread {

    void post(final Runnable runnable);

}