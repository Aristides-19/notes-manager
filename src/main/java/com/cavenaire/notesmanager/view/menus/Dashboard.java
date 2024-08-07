package com.cavenaire.notesmanager.view.menus;

import com.cavenaire.notesmanager.view.menus.dashboard.Counters;
import com.cavenaire.notesmanager.view.menus.dashboard.TaskBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Dashboard displayed at Menu Option from Navigation Bar
 *
 * @see com.cavenaire.notesmanager.view.menus.dashboard
 */
public class Dashboard extends JPanel {

    public Dashboard() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0, flowy, gap 0"));

        add(taskBar, "push, grow");
        add(appInfo, "push, grow");
    }

    // PANELS
    private final TaskBar taskBar = new TaskBar();
    private final Counters appInfo = new Counters();
}
