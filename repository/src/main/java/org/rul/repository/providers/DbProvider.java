package org.rul.repository.providers;

/**
 * Created by Rul on 02/12/2016.
 */

public interface DbProvider<T> {

    T getDatabase();

}