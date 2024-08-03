package com.cavenaire.notesmanager.view.ui;

import net.miginfocom.swing.MigLayout;

import com.cavenaire.notesmanager.view.bars.*;
import com.cavenaire.notesmanager.view.menus.*;

import javax.swing.*;

/**
 * Main UI Container, it instantiates Navigation Bar, Title Bar, and Menus.
 */
class MainPanel extends JPanel {

    MainPanel() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0, gap 0 0", "[fill]", "[fill]"));

        add(navBar, "span 1 2, w n:272:n");
        add(titleBar, "wrap, pushx, h 50!");
        add(dashboard, "push");
    }

    private final NavBar navBar = new NavBar();
    private final TitleBar titleBar = new TitleBar();
    private final Dashboard dashboard = new Dashboard();
}
