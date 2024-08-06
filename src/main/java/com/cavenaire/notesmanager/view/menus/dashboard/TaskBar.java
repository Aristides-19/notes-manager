package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.components.DashboardInfo;
import com.cavenaire.notesmanager.view.components.MenuButton;

import javax.swing.*;

/**
 * This Panel shows information about the latest client and action button
 *
 * @see com.cavenaire.notesmanager.view.components.DashboardInfo
 * @see com.cavenaire.notesmanager.view.components.MenuButton
 */
public class TaskBar extends JPanel {

    public TaskBar() {
        super();
        init();
    }

    private void init() {
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
    }
}
