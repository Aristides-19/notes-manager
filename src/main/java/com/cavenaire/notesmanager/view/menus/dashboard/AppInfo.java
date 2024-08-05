package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;

public class AppInfo extends JPanel {

    public AppInfo() {
        super();
        init();
    }

    private void init() {
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
    }

}
