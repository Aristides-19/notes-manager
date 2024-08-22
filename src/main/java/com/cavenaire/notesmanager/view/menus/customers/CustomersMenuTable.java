package com.cavenaire.notesmanager.view.menus.customers;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.MenuTextField;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.table.MenuTable;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Shows the customer's table with full interaction with CRUD customers.
 *
 * @see MenuTable
 */
@Component
public class CustomersMenuTable extends JPanel {

    public CustomersMenuTable(MenuTable<Customer> customersTable, MenuTextField searchCustomers, MenuButton addCustomer) {
        super();
        this.customersTable = customersTable;
        this.searchCustomers = searchCustomers;
        this.addCustomer = addCustomer;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0 40 40 40", "", "[]20[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
        setPreferredSize(new Dimension(0, 500));

        add(searchCustomers, "split 2");
        add(addCustomer, "gapleft push, wrap");
        add(customersTable.getScrollPane(), "push, grow, span 2 2");
    }

    // COMPONENTS
    private final MenuTable<Customer> customersTable;
    private final MenuTextField searchCustomers;
    private final MenuButton addCustomer;
}
