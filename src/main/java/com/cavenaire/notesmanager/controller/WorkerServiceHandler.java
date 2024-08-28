package com.cavenaire.notesmanager.controller;

import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.view.observer.Notifier;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

@AllArgsConstructor
@RequiredArgsConstructor
public class WorkerServiceHandler<T> extends SwingWorker<T, Void> {

    private final Supplier<T> backgroundTask;
    private final Consumer<T> doneTask;
    private final Notifier viewNotifier;
    private final Logger logger = LoggerFactory.getLogger(WorkerServiceHandler.class);
    private final String viewMessage;
    private final String logMessage;
    private String confirmationMessage;

    @Override
    protected T doInBackground() {
        return backgroundTask.get();
    }

    @Override
    protected void done() {
        try {
            T result = get();
            doneTask.accept(result);
            if (confirmationMessage != null) {
                viewNotifier.notify(confirmationMessage);
            }
        } catch (ExecutionException | InterruptedException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ServiceLayerException) {
                viewNotifier.notify(viewMessage);
                logger.error(logMessage, cause);
            } else {
                viewNotifier.notify("Error inesperado, si el error persiste notifica al desarrollador.");
                logger.error("Worker Thread Exception, most likely to be a programmer error", e);
            }
        }
    }
}
