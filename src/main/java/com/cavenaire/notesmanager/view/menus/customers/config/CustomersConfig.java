package com.cavenaire.notesmanager.view.menus.customers.config;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.table.models.CustomerTableModel;
import com.cavenaire.notesmanager.view.table.MenuTable;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomersConfig {

    @Bean
    public MenuTable<Customer> customersTable() {
        return new MenuTable<>(new CustomerTableModel(), 50, 185, 153, 157, 450);
    }

    @Bean
    public MenuButton addCustomer() {
        return new MenuButton(new FlatSVGIcon("images/menus/add.svg"), "Nuevo Cliente", 7);
    }
}
