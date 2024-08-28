package com.cavenaire.notesmanager.view.handlers.utils;

import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.ui.dialogs.MainDialog;

public class CheckDisplayConfirmation {

    public static void checkConfirmation(Runnable e, MainDisplay mainDisplay, MainDialog dialog) {
        boolean result = true;
        if (mainDisplay.needsConfirmation()) {
            result = dialog.onDialog("Si sales de este menú, se perderán los cambios.", MainDialog.ACCEPT_CANCEL_OPTION);
        }
        if (result) {
            e.run();
        }
    }
}
