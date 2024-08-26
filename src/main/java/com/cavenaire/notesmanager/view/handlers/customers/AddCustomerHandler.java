package com.cavenaire.notesmanager.view.handlers.customers;

import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;

import org.springframework.stereotype.Component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@Component
public class AddCustomerHandler {

    public void initFieldHandler(EntityAttrTextField b, String type) {
        switch (type) {
            case "fullName", "document" -> requiredField(b);
        }
    }

    private void requiredField(EntityAttrTextField b) {
        b.getField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                var container = b.getFieldContainer();
                if (container.isOnPlaceholder()) {
                    container.showErrorBorder();
                } else {
                    container.showRegularBorder();
                }
            }
        });
    }
}
