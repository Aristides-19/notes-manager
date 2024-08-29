package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.view.components.menus.textfield.SearchTextField;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;

/**
 * Search Queries Events Handler. It calls {@code controller} to perform search with a specified query from user.
 */
@Component
@RequiredArgsConstructor
public class SearchQueryHandler {

    private final Controller controller;

    public void initHandler(SearchTextField field, String type) {
        switch (type) {
            case "customers" -> initHandler(field, () -> controller.findCustomersByName(field.isOnPlaceholder() ? "" : field.getText()));
            case "invoices" -> {
            }
        }
    }

    private void initHandler(SearchTextField field, Runnable controllerQuery) {
        ActionListener event = (e) -> {
            var text = field.getText();
            if (text.length() < 3 && !text.isEmpty()) {
                field.showErrorBorder();
            } else {
                field.showRegularBorder();
                controllerQuery.run();
            }
        };
        field.addActionListener(event);
        field.getActionIcon().addActionListener(event);
    }
}
