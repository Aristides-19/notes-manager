package com.cavenaire.notesmanager.view.menus.config;

import com.cavenaire.notesmanager.view.menus.Display;
import com.cavenaire.notesmanager.view.menus.customers.AddCustomerFields;
import com.cavenaire.notesmanager.view.menus.customers.AddCustomerTaskBar;
import com.cavenaire.notesmanager.view.menus.customers.CustomersMenuTable;
import com.cavenaire.notesmanager.view.menus.customers.CustomersTaskBar;
import com.cavenaire.notesmanager.view.menus.dashboard.Counters;
import com.cavenaire.notesmanager.view.menus.dashboard.DashTaskBar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * Configurates menu displays as beans. It is useful to follow single responsibility and autowiring.
 */
@Configuration
public class DisplayConfig {

    @Bean
    public Display dashboard(DashTaskBar tb, Counters c) {
        return new Display(tb, c);
    }

    @Bean
    public Display invoices() {
        return new Display(new JLabel("Facturas"), new JLabel());
    }

    @Bean
    public Display notes() {
        return new Display(new JLabel("Notas de Entrega"), new JLabel());
    }

    @Bean
    public Display customers(CustomersTaskBar ctb, CustomersMenuTable cmt) {
        return new Display(ctb, cmt);
    }

    @Bean
    public Display settings() {
        return new Display(new JLabel("Configuración"), new JLabel());
    }

    @Bean
    public Display help() {
        return new Display(new JLabel("Ayuda"), new JLabel());
    }

    @Bean
    public Display addCustomer(AddCustomerTaskBar actb, AddCustomerFields acf) {
        return new Display(actb, acf);
    }
}
