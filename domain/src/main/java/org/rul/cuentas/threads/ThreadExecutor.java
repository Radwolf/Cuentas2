package org.rul.cuentas.threads;

import org.rul.cuentas.interactors.base.Interactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by Rul on 02/12/2016.
 */

public class ThreadExecutor implements InteractorExecutor{

    private static final int CORE_POOL_SIZE = 3;

    private static final int MAX_POOL_SIZE = 5;

    private static final int KEEP_ALIVE_TIME = 120;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public ThreadExecutor() {
        threadPoolExecutor =
                new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
                        WORK_QUEUE);
    }

    @Override
    public void executeInteractor(final Interactor interactor) {
        if (interactor == null) {
            throw new IllegalArgumentException("Interactor must not be null");
        }
        threadPoolExecutor.submit(new Runnable() {
            @Override public void run() {
                interactor.execute();
            }
        });
    }

}