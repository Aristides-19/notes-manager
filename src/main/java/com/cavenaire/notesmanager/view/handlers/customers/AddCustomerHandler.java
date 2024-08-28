package com.cavenaire.notesmanager.view.handlers.customers;

import com.cavenaire.notesmanager.controller.Controller;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

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

    public void initHandler(MenuButton b) {

    }
}
