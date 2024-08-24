package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.components.bars.NavButton;

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

    private MainDisplay mainDisplay;
    private Controller controller;

    public void initHandler(NavButton b, String type) {
        if (type.equals("menu")) {
            selected = b;
        }

        switch (type) {
            case "menu" -> b.addActionListener(e -> {
                changeSelection(b);
                controller.updateDashboard();
                mainDisplay.onMenu();
            });
            case "invoices" -> b.addActionListener(e -> {
                changeSelection(b);
                mainDisplay.onInvoices();
            });
            case "notes" -> b.addActionListener(e -> {
                changeSelection(b);
                mainDisplay.onNotes();
            });
            case "clients" -> b.addActionListener(e -> {
                changeSelection(b);
                controller.updateCustomers();
                mainDisplay.onCustomers();
            });
            case "settings" -> b.addActionListener(e -> {
                changeSelection(b);
                mainDisplay.onSettings();
            });
            case "help" -> b.addActionListener(e -> {
                changeSelection(b);
                mainDisplay.onHelp();
            });
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
