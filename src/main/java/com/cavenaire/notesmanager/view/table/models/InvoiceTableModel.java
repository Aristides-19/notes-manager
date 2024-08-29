package com.cavenaire.notesmanager.view.table.models;

import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.view.utils.Formatter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Implementation for Invoice Records Table Model
 */
public class InvoiceTableModel extends AbstractMenuTableModel<InvoiceRecord> {

    public InvoiceTableModel() {
        super(new String[]{"#", "Cliente", "Fecha", "Estatus", "Base Imponible", "Total"});
        setRows(new ArrayList<>());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceRecord invoice = rows.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> invoice.getInvoiceId();
            case 1 -> invoice.getCustomer().getFullName();
            case 2 -> invoice.getCreatedOn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            case 3 -> invoice.getStatus() == 0 ? "Borrador" : "Terminado";
            case 4 -> Formatter.formatBsCurrency(invoice.getSubtotal());
            case 5 -> Formatter.formatBsCurrency(invoice.getTotal());
            default -> null;
        };
    }

    @Override
    public int getStatusColumnIndex() {
        return 3;
    }
}
