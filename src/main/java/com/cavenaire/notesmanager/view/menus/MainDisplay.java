package com.cavenaire.notesmanager.view.menus;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * App Main Display, It contains every menu Panel. It takes care of moving between menus according to nav bar.
 */
public class MainDisplay extends JPanel {

    public MainDisplay() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("debug, insets 0"));
        add(dashboard, "push, grow");
    }

    // DISPLAY PANELS
    private final Dashboard dashboard = new Dashboard();
}
