package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.menus.MainDisplay;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * AddEntityHandler, it only gets care of switching between a main display from {@code NavBarHandler} to a
 * nested display panel. It doesn't offer functionality for components on nested panels.
 *
 * @see MainDisplay
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class NestedDisplayHandler {

    private MainDisplay mainDisplay;

    public void initHandler(MenuButton b, String type) {
        switch (type) {
            case "customer" -> b.addActionListener((e) -> mainDisplay.onAddCustomer());
        }
    }
}
