/*
 * Copyright (c) 2016. Alejandro Sánchez.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.rul.cuentas.interactors.base;

import com.asy.realmexample.threads.InteractorExecutor;
import com.asy.realmexample.threads.MainThread;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 13/4/16.
 */
public abstract class BaseInteractor {

    private MainThread mainThread;

    private InteractorExecutor interactorExecutor;

    public BaseInteractor(InteractorExecutor interactorExecutor, MainThread mainThread) {
        this.interactorExecutor = interactorExecutor;
        this.mainThread = mainThread;
    }

    public InteractorExecutor getInteractorExecutor() {
        return interactorExecutor;
    }

    public MainThread getMainThread() {
        return mainThread;
    }
}
