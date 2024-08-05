package com.cavenaire.notesmanager.view.components;

import com.cavenaire.notesmanager.view.styles.Palette;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Menu Button. It is used in menus like dashboard.
 */
public class MenuButton extends JButton {

    public MenuButton(FlatSVGIcon icon, String text, int iconGap) {
        super(text);

        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.BACKGROUND));
        setIcon(icon);

        init(iconGap);
    }

    private void init(int iconGap) {
        setPreferredSize(SIZE);
        setIconTextGap(iconGap);
        setHorizontalAlignment(SwingConstants.LEADING);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(FONT);

        putClientProperty("FlatLaf.style",
                "background : " + Palette.MENU_HEX +
                        "; hoverBackground : " + Palette.MENU_HEX +
                        "; pressedBackground : " + Palette.MENU_PRESSED_HEX +
                        "; foreground : " + Palette.BACKGROUND_HEX +
                        "; arc : 5 ; borderWidth : 0 ; margin : 0,26,0,0");

        setCursor(CURSOR);
    }

    // COMMONS
    private static final Dimension SIZE = new Dimension(178, 45);
    private static final Font FONT = new Font("Satoshi Bold", Font.BOLD, 15);
    private static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);
}
