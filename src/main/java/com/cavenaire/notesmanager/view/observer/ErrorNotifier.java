package com.cavenaire.notesmanager.view.observer;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class ErrorNotifier {

    public void notifyError(String message) {
        EventQueue.invokeLater(() -> System.out.println(message));
    }

}
