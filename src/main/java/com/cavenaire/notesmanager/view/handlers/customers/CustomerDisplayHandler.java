package com.cavenaire.notesmanager.view.handlers.customers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;
import com.cavenaire.notesmanager.view.handlers.utils.CheckDisplayConfirmation;
import com.cavenaire.notesmanager.view.handlers.utils.ValidationUtils;
import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.ui.dialogs.MainDialog;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * It takes care of init handling events for adding customer fields and validating data in fields.
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class CustomerDisplayHandler {

    private MainDisplay mainDisplay;
    private MainDialog dialog;

    public void initFieldHandler(EntityAttrTextField field, String type) {
        switch (type) {
            case "fullName" -> initFieldHandler(field, ValidationUtils::formatName, ValidationUtils::isNameValid);
            case "document" -> initFieldHandler(field, ValidationUtils::formatDoc, ValidationUtils::isDocValid);
            case "contact" -> initFieldHandler(field, ValidationUtils::formatContact, ValidationUtils::isContactValid);
            case "date" -> initFieldHandler(field, ValidationUtils::formatDate, ValidationUtils::isDateValid);
        }
    }

    public void initBack(MenuButton b) {
        b.addActionListener((e) -> CheckDisplayConfirmation.checkConfirmation(mainDisplay::onCustomers, mainDisplay, dialog));
    }

    private void initFieldHandler(EntityAttrTextField field, Function<String, String> formatter, Predicate<String> validator) {
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!field.isOnPlaceholder()) {
                    String formatted = formatter.apply(field.getText());
                    field.setText(formatted);
                    if (validator.test(formatted)) {
                        field.showRegularBorder();
                    } else {
                        field.showErrorBorder();
                    }
                } else if (field.isRequired()) {
                    field.showErrorBorder();
                } else {
                    field.showRegularBorder();
                }
            }
        });
    }
}
