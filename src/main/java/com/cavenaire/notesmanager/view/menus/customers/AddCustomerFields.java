package com.cavenaire.notesmanager.view.menus.customers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;
import com.cavenaire.notesmanager.view.styles.Palette;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AddCustomerFields extends JPanel {

    public AddCustomerFields(EntityAttrTextField fullNameField, EntityAttrTextField documentField, EntityAttrTextField addressField,
                             EntityAttrTextField contactField, EntityAttrTextField secondContactField, EntityAttrTextField dateField, MenuButton saveCustomer) {
        this.fullNameField = fullNameField;
        this.documentField = documentField;
        this.addressField = addressField;
        this.contactField = contactField;
        this.secondContactField = secondContactField;
        this.dateField = dateField;
        this.saveCustomer = saveCustomer;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 20 55 0 55", "[]80[]", "[]0[]"));
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(fullNameField, "pushx, growx");
        add(documentField, "pushx, wrap, growx");
        add(addressField, "span 2 1, wrap, growx");
        add(contactField, "pushx, growx");
        add(dateField, "pushx, wrap, growx");
        add(secondContactField, "pushx, growx");
        add(saveCustomer, "pushx, pad 15");
    }

    // COMPONENTS
    private final EntityAttrTextField fullNameField;
    private final EntityAttrTextField documentField;
    private final EntityAttrTextField addressField;
    private final EntityAttrTextField contactField;
    private final EntityAttrTextField secondContactField;
    private final EntityAttrTextField dateField;
    private final MenuButton saveCustomer;
}
