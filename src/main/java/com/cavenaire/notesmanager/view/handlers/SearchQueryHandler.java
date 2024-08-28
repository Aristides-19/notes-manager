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
            case "customers" -> {
                ActionListener event = (e) -> {
                    var text = field.getText();
                    if (text.length() < 3 && !text.isEmpty()) {
                        field.showErrorBorder();
                    } else {
                        field.showRegularBorder();
                        controller.findCustomersByName(field.isOnPlaceholder() ? "" : text);
                    }
                };
                field.addActionListener(event);
                field.getActionIcon().addActionListener(event);
            }
        }
    }
}
