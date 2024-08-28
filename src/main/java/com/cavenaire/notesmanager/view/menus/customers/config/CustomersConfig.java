package com.cavenaire.notesmanager.view.menus.customers.config;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.EntityAttrTextField;
import com.cavenaire.notesmanager.view.components.menus.textfield.SearchTextField;
import com.cavenaire.notesmanager.view.handlers.customers.AddCustomerHandler;
import com.cavenaire.notesmanager.view.handlers.customers.CustomerDisplayHandler;
import com.cavenaire.notesmanager.view.handlers.NestedDisplayHandler;
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
    private NestedDisplayHandler nestedDisplayHandler;
    private CustomerDisplayHandler customerDisplayHandler;
    private AddCustomerHandler addCustomerHandler;

    @Bean
    public MenuTable<Customer> customersTable() {
        return new MenuTable<>(new CustomerTableModel(), 50, 185, 153, 157, 450);
    }

    @Bean
    public MenuButton addCustomerButton() {
        var addCustomer = new MenuButton(new FlatSVGIcon("images/menus/add.svg"), "Nuevo Cliente", 7);
        nestedDisplayHandler.initHandler(addCustomer, "customer");
        return addCustomer;
    }

    @Bean
    public SearchTextField searchCustomers() {
        var searchField = new SearchTextField("Búsqueda", 356);
        queryHandler.initHandler(searchField, "customers");
        return searchField;
    }

    @Bean
    public MenuButton exportCustomers() {
        return new MenuButton(new FlatSVGIcon("images/menus/export.svg"), "Exportar", 15);
    }

    @Bean
    public MenuButton goBackCustomers() {
        var goBackButton = new MenuButton(new FlatSVGIcon("images/menus/corner-upleft.svg"), "Volver", 20);
        customerDisplayHandler.initBack(goBackButton);
        return goBackButton;
    }

    @Bean
    public MenuButton saveCustomer() {
        var saveButton = new MenuButton(new FlatSVGIcon("images/menus/check.svg"), "Finalizar", 15);
        addCustomerHandler.initHandler(saveButton);
        return saveButton;
    }

    @Bean
    public EntityAttrTextField fullNameField() {
        var fullNameField = new EntityAttrTextField("Nombre Completo", true, "John Doe");
        customerDisplayHandler.initFieldHandler(fullNameField, "fullName");
        return fullNameField;
    }

    @Bean
    public EntityAttrTextField documentField() {
        var documentField = new EntityAttrTextField("Documento", true, "12.345.678");
        customerDisplayHandler.initFieldHandler(documentField, "document");
        return documentField;
    }

    @Bean
    public EntityAttrTextField addressField() {
        return new EntityAttrTextField("Dirección Completa", false, "Av. Francisco de Miranda, Caracas, Distrito Capital");
    }

    @Bean
    public EntityAttrTextField contactField() {
        var contactField = new EntityAttrTextField("Contacto Principal", false, "0424-1234567");
        customerDisplayHandler.initFieldHandler(contactField, "contact");
        return contactField;
    }

    @Bean
    public EntityAttrTextField secondContactField() {
        var secContactField = new EntityAttrTextField("Contacto Secundario", false, "0212-1234567");
        customerDisplayHandler.initFieldHandler(secContactField, "contact");
        return secContactField;
    }

    @Bean
    public EntityAttrTextField dateField() {
        var dateField = new EntityAttrTextField("Fecha", false, "dd-mm-aaaa");
        customerDisplayHandler.initFieldHandler(dateField, "date");
        return dateField;
    }
}
