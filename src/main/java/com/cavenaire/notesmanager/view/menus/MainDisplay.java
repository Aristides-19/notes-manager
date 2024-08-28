package com.cavenaire.notesmanager.view.menus;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * App Main Display, It contains every menu Panel. It takes care of moving between menus according to nav bar.
 *
 * @see com.cavenaire.notesmanager.view.menus.Display
 */
@Component
public class MainDisplay extends JPanel {

    public MainDisplay(Display dashboard, Display invoices, Display notes, Display customers, Display settings, Display help,
                       Display addCustomer) {
        super();
        this.dashboard = dashboard;
        this.invoices = invoices;
        this.notes = notes;
        this.customers = customers;
        this.settings = settings;
        this.help = help;
        this.addCustomer = addCustomer;
        this.selected = dashboard;
        init();
    }

    private void init() {
        layout = new MigLayout("insets 0");
        setLayout(layout);
        String constraints = "hidemode 3";

        add(dashboard, constraints);
        add(invoices, constraints);
        add(notes, constraints);
        add(customers, constraints);
        add(settings, constraints);
        add(help, constraints);
        add(addCustomer, constraints);

        onMenu();
    }

    public void onMenu() {
        needsConfirmation = false;
        change(dashboard);
    }

    public void onInvoices() {
        needsConfirmation = false;
        change(invoices);
    }

    public void onNotes() {
        needsConfirmation = false;
        change(notes);
    }

    public void onCustomers() {
        needsConfirmation = false;
        change(customers);
    }

    public void onSettings() {
        needsConfirmation = false;
        change(settings);
    }

    public void onHelp() {
        needsConfirmation = false;
        change(help);
    }

    public void onAddCustomer() {
        needsConfirmation = true;
        change(addCustomer);
    }

    private void change(Display to) {
        layout.setComponentConstraints(selected, "hidemode 3");
        selected.setVisible(false);
        layout.setComponentConstraints(to, "push, grow, wmin 900");
        to.setVisible(true);
        selected = to;
    }

    // DISPLAY PANELS
    private final Display dashboard;
    private final Display invoices;
    private final Display notes;
    private final Display customers;
    private final Display settings;
    private final Display help;
    // NESTED PANELS
    private final Display addCustomer;

    // VARIABLES
    @Getter
    @Accessors(fluent = true)
    private boolean needsConfirmation;
    private Display selected;
    private MigLayout layout;
}
