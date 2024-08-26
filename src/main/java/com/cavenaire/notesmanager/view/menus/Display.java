package com.cavenaire.notesmanager.view.menus;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Display Template for Main Display.
 * It is intended to be a template for a {@code menu panel}.
 * So, basically every menu must be divided in two {@code subpanels}, both will push and grow their components;
 * that is why it doesn't matter sizes, because they will take over the necessary space.
 *
 * @see com.cavenaire.notesmanager.view.menus.MainDisplay
 */
public class Display extends JPanel {

    public Display(JComponent top, JComponent bottom) {
        super();
        this.top = top;
        this.bottom = bottom;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0, flowy, gap 0"));

        add(top, "push, grow");
        add(bottom, "push, grow");
        setVisible(false);
    }

    // PANELS
    private final JComponent top;
    private final JComponent bottom;
}
