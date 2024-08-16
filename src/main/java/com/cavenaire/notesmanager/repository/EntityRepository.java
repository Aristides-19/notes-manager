package com.cavenaire.notesmanager.repository;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * Primitive repository specification for Model interaction with the database.
 * Implementations must be wired in their {@code Service} layer.
 * {@code Transactions} must be managed by {@code Service}.
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
     * @return POJO entity. It can be {@code null}
     */
    Optional<T> getById(N id);

    /**
     * Get total entities on table.
     *
     * @return a count representing total numbers
     */
    int getCount();

    /**
     * Find all entities.
     *
     * @return a {@code List} containing every entity
     */
    List<T> findAll();

}
