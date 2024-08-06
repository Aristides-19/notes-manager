package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.ui.MainUI;

/**
 * Title Buttons Event Handling
 *
 * @see com.cavenaire.notesmanager.view.ui.MainUI
 */
public class TitleButtonHandler {

    public static void onClose() {
        System.exit(0);
    }

    public static void onMaximize() {
        MainUI.setMaximized();
    }

    public static void onResized() {
        MainUI.setResized();
    }

    public static void onMinimize() {
        MainUI.setMinimized();
    }
}
