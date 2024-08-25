package com.cavenaire.notesmanager.view.menus.customers.config;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.SearchTextField;
import com.cavenaire.notesmanager.view.handlers.SearchQueryHandler;
import com.cavenaire.notesmanager.view.table.models.CustomerTableModel;
import com.cavenaire.notesmanager.view.table.MenuTable;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
public class CustomersConfig {

    private SearchQueryHandler queryHandler;

    @Bean
    public MenuTable<Customer> customersTable() {
        return new MenuTable<>(new CustomerTableModel(), 50, 185, 153, 157, 450);
    }

    @Bean
    public MenuButton addCustomer() {
        return new MenuButton(new FlatSVGIcon("images/menus/add.svg"), "Nuevo Cliente", 7);
    }

    @Bean
    public SearchTextField searchCustomers() {
        var searchField = new SearchTextField("Búsqueda", 356, "10", "15", "10", "15");
        queryHandler.initHandler(searchField, "customers");
        return searchField;
    }

    @Bean
    public MenuButton exportCustomers() {
        return new MenuButton(new FlatSVGIcon("images/menus/export.svg"), "Exportar", 15);
    }
}
