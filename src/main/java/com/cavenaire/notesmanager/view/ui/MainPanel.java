package com.cavenaire.notesmanager.view.ui;

import net.miginfocom.swing.MigLayout;

import com.cavenaire.notesmanager.view.bars.*;
import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;

/**
 * Main UI Container, it instantiates Navigation Bar, Title Bar, and Menus.
 *
 * @see com.cavenaire.notesmanager.view.bars
 * @see com.cavenaire.notesmanager.view.menus
 */
class MainPanel extends JPanel {

    MainPanel() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0, gap 0 0", "[fill]", "[fill]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        displayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        displayScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add(navBar, "span 1 2, w 255:272:n");
        add(titleBar, "wrap, pushx, h 55!, gaptop 5, gapright 5");
        add(displayScrollPane, "push, gapbottom 5, gapright 5");
    }

    // COMPONENTS
    private final NavBar navBar = new NavBar();
    private final TitleBar titleBar = new TitleBar();
    private final MainDisplay display = new MainDisplay();
    private final JScrollPane displayScrollPane = new JScrollPane(display);
}
