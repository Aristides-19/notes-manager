package com.cavenaire.notesmanager.view.menus.dashboard.config;

import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardCounter;
import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardInfo;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardConfig {

    @Bean
    public DashboardInfo latestCustomerInfo() {
        return new DashboardInfo(new FlatSVGIcon("images/menus/dashboard/activity.svg"));
    }

    @Bean
    public DashboardCounter invoicesCounter() {
        return new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/invoice.svg"), "Facturas Registradas");
    }

    @Bean
    public DashboardCounter customersCounter() {
        return new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/customers.svg"), "Clientes Registrados");
    }

    @Bean
    public DashboardCounter naturalsCounter() {
        return new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/natural.svg"), "Naturales");
    }

    @Bean
    public DashboardCounter juridicalsCounter() {
        return new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/juridical.svg"), "Jurídicos");
    }
}
