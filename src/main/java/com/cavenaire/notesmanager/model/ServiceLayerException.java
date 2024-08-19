package com.cavenaire.notesmanager.model;

import org.springframework.dao.DataAccessException;

import java.util.function.Supplier;

/**
 * It is a {@code RuntimeException} that must be thrown by {@code Service} layer when there is an error. <br/>
 * It must be catched by {@code Controller} layer and notify the {@code View} about the error. <br/>
 * Besides it provides static methods to handle a {@code DataAccessException},
 * and instead throw a {@code ServiceLayerException}.
 */
public class ServiceLayerException extends RuntimeException {

    public ServiceLayerException(Throwable cause) {
        super(cause);
    }

    public static <T> T exceptionHandler(Supplier<T> repoCall) {
        try {
            return repoCall.get();
        } catch (DataAccessException e) {
            throw new ServiceLayerException(e);
        }
    }

    public static void exceptionHandler(Runnable repoCall) {
        try {
            repoCall.run();
        } catch (DataAccessException e) {
            throw new ServiceLayerException(e);
        }
    }

}
