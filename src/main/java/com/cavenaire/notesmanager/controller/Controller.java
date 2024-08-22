package com.cavenaire.notesmanager.controller;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.customer.service.CustomerService;
import com.cavenaire.notesmanager.model.invoicerecord.service.InvoiceService;
import com.cavenaire.notesmanager.view.observer.ErrorNotifier;
import com.cavenaire.notesmanager.view.observer.menus.CustomersObservable;
import com.cavenaire.notesmanager.view.observer.menus.DashboardObservable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller {

    private final ErrorNotifier viewErrorNotifier;
    // SERVICES
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    // OBSERVERS
    private final DashboardObservable dashboardObservable;
    private final CustomersObservable customersObservable;

    public void updateDashboard() {
        new WorkerServiceHandler<>(() -> {
            var latestCustomer = customerService.getByLastTimestamp();
            var customersCount = customerService.getCount();
            var typesCount = customerService.getCountByType();
            var invoicesCount = invoiceService.getCount();
            return new Object[]{latestCustomer, customersCount, typesCount.get("natural"), typesCount.get("juridical"), invoicesCount};
        }, (result) -> {
            dashboardObservable.updateLatestCustomer((Customer) result[0]);
            dashboardObservable.updateCustomersCount((Integer) result[1]);
            dashboardObservable.updateNaturalsCount((Integer) result[2]);
            dashboardObservable.updateJuridicalsCount((Integer) result[3]);
            dashboardObservable.updateInvoicesCount((Integer) result[4]);
        }, viewErrorNotifier, "No se pudo actualizar el menú principal, inténtalo de nuevo", "Failed to update dashboard").execute();
    }

    public void updateCustomers() {
        new WorkerServiceHandler<>(() -> customerService.findAll(25),
                customersObservable::updateCustomersTable, viewErrorNotifier,
                "No se pudo actualizar la tabla de clientes, inténtalo de nuevo",
                "Failed to update customers table").execute();
    }

    public void findCustomersByName(String query) {
        new WorkerServiceHandler<>(() -> customerService.findAllByName(query),
                customersObservable::updateCustomersTable, viewErrorNotifier,
                "No se pudo realizar la búsqueda, inténtalo de nuevo.\nRecuerda verificar que tu búsqueda contenga al menos 2 letras",
                "Failed to perform customers search by name").execute();
    }
}
