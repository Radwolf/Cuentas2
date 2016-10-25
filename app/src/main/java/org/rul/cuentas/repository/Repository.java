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

package org.rul.cuentas.repository;

import org.rul.cuentas.repository.exceptions.RepositoryException;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T insert(T element) throws RepositoryException;

    List<T> insertAll(List<T> elementList) throws RepositoryException;

    void remove(T element);

    void removeAll();

}
