package com.cavenaire.notesmanager.view.observer;

import com.cavenaire.notesmanager.view.ui.dialogs.MainDialog;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
public class Notifier {

    private MainDialog dialog;

    public void notify(String message) {
        dialog.onDialog(message, MainDialog.ACCEPT_OPTION);
    }

}
