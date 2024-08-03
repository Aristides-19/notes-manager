package com.cavenaire.notesmanager.view.ui;

import rob.camick.tools.ComponentResizer;

import com.cavenaire.notesmanager.view.utils.FontLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Main UI Window that contains MainPanel. It's undecorated and capable of resize.
 */
public class MainUI extends JFrame {

    public MainUI() {
        super();
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 800);

        setLocationRelativeTo(null);
        setUndecorated(true);

        cr.setMinimumSize(new Dimension(960, 600));
        cr.setMaximumSize(new Dimension(1280, 800));
        cr.setSnapSize(new Dimension(1, 1));
        cr.registerComponent(this);

        FontLoader.loadFonts();

        add(mp);
    }

    private final ComponentResizer cr = new ComponentResizer();
    private final MainPanel mp = new MainPanel();
}
