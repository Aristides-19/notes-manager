package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardCounter;
import com.cavenaire.notesmanager.view.styles.Palette;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * This Panel shows information about how many objects are in the database.
 *
 * @see DashboardCounter
 */
@Component
public class Counters extends JPanel {

    public Counters(DashboardCounter invoicesCounter, DashboardCounter customersCounter, DashboardCounter naturalsCounter, DashboardCounter juridicalsCounter) {
        super();
        this.invoicesCounter = invoicesCounter;
        this.customersCounter = customersCounter;
        this.naturalsCounter = naturalsCounter;
        this.juridicalsCounter = juridicalsCounter;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 8 55 40 55"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(invoicesCounter, "push, grow, span 2 2, gapright 10");
        add(customersCounter, "push, grow, span 2 2, gapright 30");
        add(naturalsCounter, "push, grow, wrap, gapbottom 10");
        add(juridicalsCounter, "push, grow");
    }

    // PANELS
    private final DashboardCounter invoicesCounter;
    private final DashboardCounter customersCounter;
    private final DashboardCounter naturalsCounter;
    private final DashboardCounter juridicalsCounter;
}
