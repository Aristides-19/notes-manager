package com.cavenaire.notesmanager.model;

import org.springframework.lang.NonNull;

/**
 * Primitive repository specification for business objects interaction with the database. <br/>
 * It takes care of mapping rows from a relational table to business objects. <br/>
 * Implementations must be wired in their {@code EntityService} layer.
 * {@code Transactions} and {@code DataAccessException's} must be handled by {@code Service}.
 *
 * @param <T> Business Object Model
 * @see EntityService
 */
public interface EntityRepository<T> {

    /**
     * Saves an entity.
     *
     * @param entity entity to be saved
     * @return entity saved with generated ID
     */
    T save(@NonNull T entity);

    /**
     * Deletes an entity.
     *
     * @param entity entity to be deleted
     */
    void delete(@NonNull T entity);

    /**
     * Updates an entity.
     *
     * @param entity entity to be updated
     */
    void update(@NonNull T entity);

}
