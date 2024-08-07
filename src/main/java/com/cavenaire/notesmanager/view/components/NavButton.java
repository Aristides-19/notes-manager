package com.cavenaire.notesmanager.view.components;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Navigation Button of Navigation Bar.
 */
public class NavButton extends JButton {

    public NavButton(FlatSVGIcon icon, String text) {
        super(text);
        this.icon = icon;
        init();
    }

    public void init() {
        setMinimumSize(SIZE);
        setIconTextGap(18);
        setHorizontalAlignment(SwingConstants.LEADING);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(FontPalette.H1);
        setBorder(BORDER);

        putClientProperty("FlatLaf.style",
                "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; hoverBackground : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; pressedBackground : " + Palette.BACKGROUND_HEX);

        setCursor(CURSOR);

        icon.setColorFilter(colorFilter);
        setSelected(false);
    }

    @Override
    public void setSelected(boolean selected) {
        if (selected) {
            setForeground(Palette.MAIN);
            colorFilter.add(Color.BLACK, Palette.MAIN);
        } else {
            setForeground(Palette.UNSELECT);
            colorFilter.add(Color.BLACK, Palette.UNSELECT);
        }
        setIcon(icon);
    }

    // ICON
    private final FlatSVGIcon icon;
    private final FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();

    // COMMONS
    private static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);
    private static final Border BORDER = BorderFactory.createEmptyBorder(0, 33, 0, 0);
    private static final Dimension SIZE = new Dimension(0, 55);
}
