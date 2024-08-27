package com.cavenaire.notesmanager.view.observer;

import com.cavenaire.notesmanager.view.ui.dialogs.MainDialog;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
public class ErrorNotifier {

    private MainDialog dialog;

    public void notifyError(String message) {
        EventQueue.invokeLater(() -> dialog.onDialog(message, MainDialog.ACCEPT_OPTION));
    }

}
