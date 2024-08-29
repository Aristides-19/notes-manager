package com.cavenaire.notesmanager.view.menus.invoices.config;

import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.textfield.SearchTextField;
import com.cavenaire.notesmanager.view.handlers.SearchQueryHandler;
import com.cavenaire.notesmanager.view.table.MenuTable;
import com.cavenaire.notesmanager.view.table.models.InvoiceTableModel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
public class InvoicesConfig {

    private SearchQueryHandler queryHandler;

    @Bean
    public MenuTable<InvoiceRecord> invoicesTable() {
        return new MenuTable<>(new InvoiceTableModel(), 50, 209, 138, 125, 180, 139);
    }

    @Bean
    public MenuButton addInvoice() {
        return new MenuButton(new FlatSVGIcon("images/menus/add.svg"), "Nueva Factura", 7);
    }

    @Bean
    public SearchTextField searchInvoices() {
        var searchField = new SearchTextField("Búsqueda", 356);
        queryHandler.initHandler(searchField, "invoices");
        return searchField;
    }

    @Bean
    public MenuButton exportInvoices() {
        return new MenuButton(new FlatSVGIcon("images/menus/export.svg"), "Exportar", 15);
    }
}
