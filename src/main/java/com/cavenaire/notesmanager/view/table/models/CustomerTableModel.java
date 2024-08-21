package com.cavenaire.notesmanager.view.table.models;

import com.cavenaire.notesmanager.model.customer.Customer;

import java.util.ArrayList;

/**
 * Implementation for Customers Table Model
 */
public class CustomerTableModel extends MenuTableModel<Customer> {

    public CustomerTableModel() {
        super(new String[]{"#", "Nombre", "Contacto", "Documento", "Dirección"});
        setRows(new ArrayList<>());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer row = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getCustomerId();
            case 1:
                return row.getFullName();
            case 2:
                return row.getContact();
            case 3:
                return row.getDocument();
            case 4:
                return row.getAddress();
        }
        return null;
    }
}
