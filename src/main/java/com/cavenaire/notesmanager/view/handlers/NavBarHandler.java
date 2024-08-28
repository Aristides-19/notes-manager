package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.components.bars.NavButton;

import static com.cavenaire.notesmanager.view.handlers.utils.CheckDisplayConfirmation.*;

import com.cavenaire.notesmanager.view.ui.dialogs.MainDialog;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Navigation Bar Buttons Event Handling. It calls {@code controller} to update menu display views.
 *
 * @see NavButton
 * @see com.cavenaire.notesmanager.view.menus.MainDisplay
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class NavBarHandler {

    private MainDialog dialog;
    private MainDisplay mainDisplay;
    private Controller controller;

    public void initHandler(NavButton b, String type) {
        if (type.equals("menu")) {
            selected = b;
        }

        switch (type) {
            case "menu" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                controller.updateDashboard();
                mainDisplay.onMenu();
            }, mainDisplay, dialog));
            case "invoices" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                mainDisplay.onInvoices();
            }, mainDisplay, dialog));
            case "notes" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                mainDisplay.onNotes();
            }, mainDisplay, dialog));
            case "customers" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                controller.updateCustomers();
                mainDisplay.onCustomers();
            }, mainDisplay, dialog));
            case "settings" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                mainDisplay.onSettings();
            }, mainDisplay, dialog));
            case "help" -> b.addActionListener(e -> checkConfirmation(() -> {
                changeSelection(b);
                mainDisplay.onHelp();
            }, mainDisplay, dialog));
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
