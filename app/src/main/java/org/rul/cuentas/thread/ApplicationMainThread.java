package org.rul.cuentas.thread;

import android.os.Handler;
import android.os.Looper;

import org.rul.cuentas.threads.MainThread;

import javax.inject.Inject;

/**
 * Created by Rul on 03/12/2016.
 */

public class ApplicationMainThread implements MainThread {

    private Handler handler;

    @Inject
    public ApplicationMainThread() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post( runnable );
    }
}
