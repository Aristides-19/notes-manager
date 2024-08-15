package com.cavenaire.notesmanager.view.ui;

import com.cavenaire.notesmanager.view.bars.*;
import com.cavenaire.notesmanager.view.menus.MainDisplay;
import com.cavenaire.notesmanager.view.styles.Palette;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Main UI Container, it contains Navigation Bar, Title Bar, and Menus.
 *
 * @see com.cavenaire.notesmanager.view.bars
 * @see com.cavenaire.notesmanager.view.menus
 */
@Component
public class MainPanel extends JPanel {

    public MainPanel(NavBar navBar, TitleBar titleBar, MainDisplay display) {
        super();
        this.navBar = navBar;
        this.titleBar = titleBar;
        this.displayScrollPane = new JScrollPane(display);
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
    private final NavBar navBar;
    private final TitleBar titleBar;
    private final JScrollPane displayScrollPane;
}
