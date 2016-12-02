package org.rul.domain.repository;

import org.rul.domain.repository.exceptions.RepositoryException;
import java.util.List;

/**
 * Class Description.
 *
 * @author raul.gomo@gmail.com.
 * @version 1.0.
 * @since 02/12/2016.
 */
public interface Repository<T> {

    List<T> findAll();

    T insert(T element) throws RepositoryException;

    List<T> insertAll(List<T> elementList) throws RepositoryException;

    void remove(T element);

    void removeAll();

}
