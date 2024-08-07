package com.cavenaire.notesmanager.view.menus;

import com.cavenaire.notesmanager.view.menus.dashboard.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * App Main Display, It contains every menu Panel. It takes care of moving between menus according to nav bar.
 *
 * @see com.cavenaire.notesmanager.view.menus.Display
 */
public class MainDisplay extends JPanel {

    public MainDisplay() {
        super();
        init();
    }

    private void init() {
        layout = new MigLayout("insets 0");
        setLayout(layout);
        String constraints = "hidemode 3";

        add(dashboard, constraints);
        add(invoices, constraints);
        add(notes, constraints);
        add(clients, constraints);
        add(settings, constraints);
        add(help, constraints);

        onMenu();
    }

    public static void onMenu() {
        change(dashboard);
    }

    public static void onInvoices() {
        change(invoices);
    }

    public static void onNotes() {
        change(notes);
    }

    public static void onClients() {
        change(clients);
    }

    public static void onSettings() {
        change(settings);
    }

    public static void onHelp() {
        change(help);
    }

    private static void change(Display to) {
        layout.setComponentConstraints(selected, "hidemode 3");
        selected.setVisible(false);
        layout.setComponentConstraints(to, "push, grow, wmin 900");
        to.setVisible(true);
        selected = to;
    }

    // DISPLAY PANELS
    private static final Display<TaskBar, Counters> dashboard = new Display<>(new TaskBar(), new Counters());
    private static final Display<JLabel, JLabel> invoices = new Display<>(new JLabel("Facturas"), new JLabel());
    private static final Display<JLabel, JLabel> notes = new Display<>(new JLabel("Notas de Entrega"), new JLabel());
    private static final Display<JLabel, JLabel> clients = new Display<>(new JLabel("Clientes"), new JLabel());
    private static final Display<JLabel, JLabel> settings = new Display<>(new JLabel("Configuración"), new JLabel());
    private static final Display<JLabel, JLabel> help = new Display<>(new JLabel("Ayuda"), new JLabel());

    // VARIABLES
    private static Display selected = dashboard;
    private static MigLayout layout;
}
