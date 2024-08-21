package com.cavenaire.notesmanager.view.observer.menus;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.observer.ObservableContainer;
import com.cavenaire.notesmanager.view.table.MenuTable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomersObservable implements ObservableContainer {

    private final MenuTable<Customer> customersTable;

    public void updateCustomersTable(List<Customer> customers) {
        customersTable.update(customers);
    }
}
