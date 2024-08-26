package com.cavenaire.notesmanager.view.components.menus;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Subtitle Label for MenuPanels
 */
public class SubtitleLabel extends JLabel {

    public SubtitleLabel(FlatSVGIcon icon, String title, int iconGap) {
        super(title);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        setIcon(icon);
        setIconTextGap(iconGap);
        init();
    }

    private void init() {
        putClientProperty("FlatLaf.style", "foreground : " + Palette.MENU_HEX);
        setFont(FontPalette.H01);
    }
}
