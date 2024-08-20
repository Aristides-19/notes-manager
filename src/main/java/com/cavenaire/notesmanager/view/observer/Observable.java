package com.cavenaire.notesmanager.view.observer;

/**
 * It declares a basic implementation for components who can be updated from a {@code ObservableContainer} class. <br/>
 * Every component that should be updated in execution time must implement this interface. <br/>
 *
 * @param <T> param type to update component
 */
public interface Observable<T> {

    /**
     * Notify about changes to the {@code view} component.
     *
     * @param object object which changes in execution time
     */
    void update(T object);
}
