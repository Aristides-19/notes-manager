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
public class AddCustomerHandler {

    private MainDisplay mainDisplay;
    private MainDialog dialog;

    public void initFieldHandler(EntityAttrTextField b, String type, boolean required) {
        switch (type) {
            case "fullName" -> initFieldHandler(b, required, ValidationUtils::formatName, ValidationUtils::isNameValid);
            case "document" -> initFieldHandler(b, required, ValidationUtils::formatDoc, ValidationUtils::isDocValid);
            case "contact" -> initFieldHandler(b, required, ValidationUtils::formatContact, ValidationUtils::isContactValid);
            case "date" -> initFieldHandler(b, required, ValidationUtils::formatDate, ValidationUtils::isDateValid);
        }
    }

    public void initBack(MenuButton b) {
        b.addActionListener((e) -> CheckDisplayConfirmation.checkConfirmation(mainDisplay::onCustomers, mainDisplay, dialog));
    }

    private void initFieldHandler(EntityAttrTextField b, boolean required, Function<String, String> formatter, Predicate<String> validator) {
        b.getField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                var container = b.getFieldContainer();
                if (!container.isOnPlaceholder()) {
                    String formatted = formatter.apply(b.getField().getText());
                    b.getField().setText(formatted);
                    if (validator.test(formatted)) {
                        container.showRegularBorder();
                    } else if (formatted.isEmpty() && !required) {
                        b.resetField();
                    } else {
                        container.showErrorBorder();
                    }
                } else if (required) {
                    container.showErrorBorder();
                } else {
                    container.showRegularBorder();
                }
            }
        });
    }
}
