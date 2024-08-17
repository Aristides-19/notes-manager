package com.cavenaire.notesmanager.repository;

import lombok.NonNull;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * Primitive repository specification for business objects interaction with the database. <br/>
 * It takes care of mapping rows from a relational table to business objects. <br/>
 * Implementations must be wired in their {@code EntityService} layer.
 * {@code Transactions} and {@code DataAccessException's} must be handled by {@code Service}.
 *
 * @param <T> POJO Model Entity
 * @param <N> Primary Key Data Type
 */
public interface EntityRepository<@NonNull T, N> {

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
     * Deletes an entity by their ID primary key.
     *
     * @param id entity's id to be deleted
     */
    void deleteById(N id);

    /**
     * Updates an entity.
     *
     * @param entity entity to be updated
     */
    void update(@NonNull T entity);

    /**
     * Get an entity by their ID primary key.
     *
     * @param id entity's id to get
     * @return POJO entity
     * @throws EmptyResultDataAccessException if there is no entity with the id
     */
    T getById(N id) throws EmptyResultDataAccessException;

    /**
     * Get total entities on table.
     *
     * @return a count representing total entities
     */
    int getCount();

    /**
     * Find all entities.
     *
     * @return a {@code List} containing every entity
     */
    List<T> findAll();

}
