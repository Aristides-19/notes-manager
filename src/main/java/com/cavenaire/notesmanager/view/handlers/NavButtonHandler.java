package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.components.NavButton;

import static com.cavenaire.notesmanager.view.menus.MainDisplay.*;

/**
 * Navigation Bar Buttons Event Handling.
 *
 * @see com.cavenaire.notesmanager.view.components.NavButton
 * @see com.cavenaire.notesmanager.view.menus.MainDisplay
 */
public class NavButtonHandler {

    public static void initHandler(NavButton b) {
        if (b.getType() == NavButton.ButtonType.MENU) {
            selected = b;
        }
        b.addActionListener(e -> {
            b.setSelected();
            selected.setSelected();
            selected = b;
            switch (b.getType()) {
                case MENU:
                    onMenu();
                    break;
                case INVOICES:
                    onInvoices();
                    break;
                case NOTES:
                    onNotes();
                    break;
                case CLIENTS:
                    onClients();
                    break;
                case SETTINGS:
                    onSettings();
                    break;
                case HELP:
                    onHelp();
                    break;
            }
        });
    }

    // VARIABLES
    private static NavButton selected;
}
