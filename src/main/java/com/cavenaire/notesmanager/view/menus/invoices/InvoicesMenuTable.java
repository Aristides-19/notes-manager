package com.cavenaire.notesmanager.view.menus.invoices;

import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.SearchTextField;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.table.MenuTable;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Shows the invoice's table with full interaction with CRUD invoice records.
 *
 * @see MenuTable
 */
@Component
public class InvoicesMenuTable extends JPanel {

    public InvoicesMenuTable(MenuTable<InvoiceRecord> invoicesTable, SearchTextField searchInvoices, MenuButton addInvoice) {
        super();
        this.invoicesTable = invoicesTable;
        this.searchInvoices = searchInvoices;
        this.addInvoice = addInvoice;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0 40 40 40", "", "[]20[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
        setPreferredSize(new Dimension(0, 500));

        add(searchInvoices, "split 2");
        add(addInvoice, "gapleft push, wrap");
        add(invoicesTable.getScrollPane(), "push, grow, span 2 2");
    }

    // COMPONENTS
    private final MenuTable<InvoiceRecord> invoicesTable;
    private final SearchTextField searchInvoices;
    private final MenuButton addInvoice;
}
