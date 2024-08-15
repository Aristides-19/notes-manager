package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.components.bars.NavButton;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Navigation Bar Buttons Event Handling.
 *
 * @see NavButton
 * @see com.cavenaire.notesmanager.view.menus.MainDisplay
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class NavBarHandler {

    private MainDisplay mainDisplay;

    public void initHandler(NavButton b, String type) {
        if (type.equals("menu")) {
            selected = b;
        }

        switch (type) {
            case "menu":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onMenu();
                });
                break;
            case "invoices":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onInvoices();
                });
                break;
            case "notes":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onNotes();
                });
                break;
            case "clients":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onClients();
                });
                break;
            case "settings":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onSettings();
                });
                break;
            case "help":
                b.addActionListener(e -> {
                    changeSelection(b);
                    mainDisplay.onHelp();
                });
                break;
        }
    }

    private void changeSelection(NavButton b) {
        b.setSelected();
        selected.setSelected();
        selected = b;
    }

    // VARIABLES
    private NavButton selected;
}
