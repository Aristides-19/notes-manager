package com.cavenaire.notesmanager.view.menus.customers;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.table.MenuTable;
import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class CustomersMenuTable extends JPanel {

    public CustomersMenuTable(MenuTable<Customer> customersTable, MenuButton addCustomer) {
        super();
        this.customersTable = customersTable;
        this.addCustomer = addCustomer;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0 40 40 40"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(addCustomer, "push, right, wrap");
        add(customersTable.getScrollPane(), "push, grow");
    }

    // COMPONENTS
    private final MenuTable<Customer> customersTable;
    private final MenuButton addCustomer;
}
