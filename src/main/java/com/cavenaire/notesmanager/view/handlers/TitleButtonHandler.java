package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.components.TitleButton;
import com.cavenaire.notesmanager.view.ui.MainUI;

/**
 * Title Buttons Event Handling
 *
 * @see com.cavenaire.notesmanager.view.ui.MainUI
 * @see com.cavenaire.notesmanager.view.components.TitleButton
 */
public class TitleButtonHandler {

    private static void onClose() {
        System.exit(0);
    }

    private static void onMaximize() {
        MainUI.setMaximized();
    }

    private static void onResized() {
        MainUI.setResized();
    }

    private static void onMinimize() {
        MainUI.setMinimized();
    }

    public static void initHandler(TitleButton b) {
        b.addActionListener(e -> {
            switch (b.getType()) {
                case CLOSE:
                    onClose();
                    break;
                case MAXIMIZE:
                    b.changeIconState();
                    if (b.getState() == 0) {
                        onMaximize();
                        b.setState((byte) 1);
                    } else {
                        onResized();
                        b.setState((byte) 0);
                    }
                    break;
                case MINIMIZE:
                    onMinimize();
                    break;
            }
        });
    }
}
