package com.cavenaire.notesmanager.view.observer.menus;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardCounter;
import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardInfo;

import com.cavenaire.notesmanager.view.observer.ObservableContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DashboardObservable implements ObservableContainer {

    private final DashboardInfo latestCustomerInfo;
    private final DashboardCounter invoicesCounter;
    private final DashboardCounter customersCounter;
    private final DashboardCounter naturalsCounter;
    private final DashboardCounter juridicalsCounter;

    public void updateLatestCustomer(Customer customer) {
        latestCustomerInfo.update(customer);
    }

    public void updateInvoicesCount(Integer count) {
        invoicesCounter.update(count);
    }

    public void updateCustomersCount(Integer count) {
        customersCounter.update(count);
    }

    public void updateNaturalsCount(Integer count) {
        naturalsCounter.update(count);
    }

    public void updateJuridicalsCount(Integer count) {
        juridicalsCounter.update(count);
    }
}
