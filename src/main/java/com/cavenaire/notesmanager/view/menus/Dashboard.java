package com.cavenaire.notesmanager.view.menus;

import com.cavenaire.notesmanager.view.menus.dashboard.AppInfo;
import com.cavenaire.notesmanager.view.menus.dashboard.TaskBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Dashboard displayed at Menu Option from Navigation Bar
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

    private final TaskBar taskBar = new TaskBar();
    private final AppInfo appInfo = new AppInfo();
}
