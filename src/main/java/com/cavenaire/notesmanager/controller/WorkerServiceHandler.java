package com.cavenaire.notesmanager.controller;

import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.view.observer.Notifier;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class WorkerServiceHandler<T> extends SwingWorker<T, Void> {

    private final Supplier<T> backgroundTask;
    private final Consumer<T> doneTask;
    private final Notifier viewNotifier;
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
                log.error(logMessage, cause);
            } else {
                viewNotifier.notify("Error inesperado, si el error persiste notifica al desarrollador.");
                log.error("Worker Thread Exception, most likely to be a programmer error", e);
            }
        }
    }
}
