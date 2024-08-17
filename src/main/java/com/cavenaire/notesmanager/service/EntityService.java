package com.cavenaire.notesmanager.service;

import lombok.NonNull;

import java.util.List;

/**
 * Primitive service specification for business objects interaction with {@code EntityRepository}. <br/>
 * It takes care of handling {@code DataAccessException's} and {@code transactions}. <br/>
 * Even, it may interact with {@code service} from another model if there is a dependency relation.
 *
 * @param <T> POJO Model Entity
 * @param <N> Primary Key Data Type
 */
public interface EntityService<T, N> {

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
     * Deletes an entity object by their ID.
     *
     * @param id id of object to be deleted
     * @throws ServiceLayerException if it can't be performed because a database exception cause
     */
    void deleteById(N id) throws ServiceLayerException;

    /**
     * Updates an entity object.
     *
     * @param entity entity to be updated
     * @throws ServiceLayerException if it can't be performed because a database exception cause
     */
    void update(@NonNull T entity) throws ServiceLayerException;

    /**
     * Gets an entity object by their ID.
     *
     * @param id id of object to get
     * @return entity object
     * @throws ServiceLayerException if it can't be gotten because a database exception cause, or
     *                               there is no entity with the id. Use {@code getMessage()} for handling.
     */
    T getById(N id) throws ServiceLayerException;

    /**
     * Gets a count about how many entities exists.
     *
     * @return an integer representation
     * @throws ServiceLayerException if it can't be gotten because a database exception cause
     */
    int getCount() throws ServiceLayerException;

    /**
     * Finds every existing entity.
     *
     * @return a List with every entity
     * @throws ServiceLayerException if it can't be found because a database exception cause
     */
    List<T> findAll() throws ServiceLayerException;

}
