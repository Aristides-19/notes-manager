package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;

public class TaskBar extends JPanel {

    public TaskBar() {
        super();
        init();
    }

    private void init() {
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
    }
}
