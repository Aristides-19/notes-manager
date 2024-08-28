package com.cavenaire.notesmanager.view.handlers.customers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;
import com.cavenaire.notesmanager.view.menus.MainDisplay;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * It handles the AddCustomer event to save the customer with {@code Controller}
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class AddCustomerHandler {

    private EntityAttrTextField fullNameField;
    private EntityAttrTextField documentField;
    private EntityAttrTextField addressField;
    private EntityAttrTextField contactField;
    private EntityAttrTextField secondContactField;
    private EntityAttrTextField dateField;
    private Controller controller;
    private MainDisplay mainDisplay;

    public void initHandler(MenuButton b) {
        b.addActionListener(e -> {
            if (areFieldsValid()) {
                controller.saveCustomer(createCustomerFromFields());
                mainDisplay.onCustomers();
            }
        });
    }

    private boolean areFieldsValid() {
        return !fullNameField.isOnError()
                && !documentField.isOnError()
                && !addressField.isOnError()
                && !contactField.isOnError()
                && !secondContactField.isOnError()
                && !dateField.isOnError();
    }

    private Customer createCustomerFromFields() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Customer.builder()
                .fullName(fullNameField.getText())
                .document(documentField.getText())
                .address(addressField.getText())
                .contact(contactField.getText())
                .secondContact(secondContactField.getText())
                .lastTimestamp(dateField.getText().isEmpty() ? LocalDateTime.now() : LocalDate.parse(dateField.getText(), formatter).atTime(LocalTime.now()))
                .build();
    }
}
