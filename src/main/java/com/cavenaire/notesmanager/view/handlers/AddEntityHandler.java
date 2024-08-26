package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.menus.MainDisplay;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class AddEntityHandler {

    private MainDisplay mainDisplay;

    public void initHandler(MenuButton b, String type) {
        switch (type) {
            case "customer" -> b.addActionListener((e) -> mainDisplay.onAddCustomer());
        }
    }
}
