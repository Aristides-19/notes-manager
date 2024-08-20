package com.cavenaire.notesmanager.controller;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.customer.service.CustomerService;
import com.cavenaire.notesmanager.model.invoicerecord.service.InvoiceService;
import com.cavenaire.notesmanager.view.observer.menus.DashboardObservable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller {

    private final ServiceHandler serviceHandler;
    // SERVICES
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    // OBSERVERS
    private final DashboardObservable dashboardObservable;

    public void updateDashboard() {
        WorkerHandler<Object[]> worker = new WorkerHandler<>(() -> {
            var latestCustomer = customerService.getByLastTimestamp();
            var customersCount = customerService.getCount();
            var typesCount = customerService.getCountByType();
            var invoicesCount = invoiceService.getCount();
            return new Object[]{latestCustomer, customersCount, typesCount.get("natural"), typesCount.get("juridical"),
                    invoicesCount};
        }, (result) -> {
            dashboardObservable.updateLatestCustomer((Customer) result[0]);
            dashboardObservable.updateCustomersCount((Integer) result[1]);
            dashboardObservable.updateNaturalsCount((Integer) result[2]);
            dashboardObservable.updateJuridicalsCount((Integer) result[3]);
            dashboardObservable.updateInvoicesCount((Integer) result[4]);
        }, serviceHandler.getViewErrorNotifier());
        serviceHandler.handleServiceCall(worker::execute, "No se pudo actualizar el menú principal, inténtalo de nuevo",
                "Failed to update dashboard");
    }
}
