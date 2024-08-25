package com.cavenaire.notesmanager.model;

import org.springframework.lang.NonNull;

/**
 * Primitive service specification for business objects interaction with {@code EntityRepository}. <br/>
 * It takes care of handling {@code Transactions} and {@code DataAccessException's} converting them to
 * {@code ServiceLayerException}. <br/>
 * Even, it may interact with {@code service} from another object if there is a dependency relation.
 *
 * @param <T> Business Object Model
 * @see ServiceLayerException
 * @see EntityRepository
 */
public interface EntityService<T> {

    /**
     * Saves an entity object.
     *
     * @param entity entity to be saved
     * @return entity with a generated key
     * @throws ServiceLayerException if it can't be gotten/performed because a database exception cause
     */
    T save(@NonNull T entity) throws ServiceLayerException;

    /**
     * Deletes an entity object.
     *
     * @param entity entity to be deleted
     * @throws ServiceLayerException if it can't be performed because a database exception cause
     */
    void delete(@NonNull T entity) throws ServiceLayerException;

    /**
     * Updates an entity object.
     *
     * @param entity entity to be updated
     * @throws ServiceLayerException if it can't be performed because a database exception cause
     */
    void update(@NonNull T entity) throws ServiceLayerException;

}
