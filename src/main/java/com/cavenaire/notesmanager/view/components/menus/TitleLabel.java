package com.cavenaire.notesmanager.view.components.menus;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;

/**
 * Title Label for Menu Panels
 */
public class TitleLabel extends JLabel {

    public TitleLabel(String title) {
        super(title);
        init();
    }

    private void init() {
        putClientProperty("FlatLaf.style", "foreground : " + Palette.MENU_HEX);
        setFont(FontPalette.HO0);
    }
}
