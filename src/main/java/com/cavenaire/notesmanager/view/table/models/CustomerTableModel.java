package com.cavenaire.notesmanager.view.table.models;

import com.cavenaire.notesmanager.model.customer.Customer;

import java.util.ArrayList;

/**
 * Implementation for Customers Table Model
 */
public class CustomerTableModel extends AbstractMenuTableModel<Customer> {

    public CustomerTableModel() {
        super(new String[]{"#", "Nombre", "Contacto", "Documento", "Dirección"});
        setRows(new ArrayList<>());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer row = rows.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> row.getCustomerId();
            case 1 -> row.getFullName();
            case 2 -> row.getContact();
            case 3 -> row.getDocument();
            case 4 -> row.getAddress();
            default -> null;
        };
    }
}
