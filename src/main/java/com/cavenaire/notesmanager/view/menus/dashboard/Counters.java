package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.components.DashboardCounter;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * This Panel shows information about how many objects are in the database.
 *
 * @see DashboardCounter
 */
public class Counters extends JPanel {

    public Counters() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 40 55 40 55"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(invoice, "push, grow, span 2 2, gapright 10");
        add(clients, "push, grow, span 2 2, gapright 20");
        add(natural, "push, grow, wrap, gapbottom 10");
        add(juridical, "push, grow");
    }

    // PANELS
    private final DashboardCounter invoice = new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/invoice.svg"), "Facturas Registradas", "22");
    private final DashboardCounter clients = new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/clients.svg"), "Clientes Registrados", "57");
    private final DashboardCounter natural = new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/natural.svg"), "Jurídicos", "25");
    private final DashboardCounter juridical = new DashboardCounter(new FlatSVGIcon("images/menus/dashboard/juridical.svg"), "Naturales", "32");
}
