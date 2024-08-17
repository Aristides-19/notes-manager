package com.cavenaire.notesmanager.service;

/**
 * It is a {@code RuntimeException} that must be thrown by {@code Service} layer when there is an error. <br/>
 * It must be catched by {@code Controller} layer and notify the {@code View} about the message. <br/>
 * The message should be descriptive about the error, that way the view can show it.
 */
public class ServiceLayerException extends RuntimeException {

    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
