package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.view.components.menus.MenuTextField;

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

    public void initHandler(MenuTextField field, String type) {
        switch (type) {
            case "customers":
                var textField = field.getTextField();
                ActionListener event = (e) -> controller.findCustomersByName(textField.getText().equals(field.getDefaultText()) ? textField.getText() : "");
                textField.addActionListener(event);
                field.getSearchButton().addActionListener(event);
                break;
        }
    }
}
