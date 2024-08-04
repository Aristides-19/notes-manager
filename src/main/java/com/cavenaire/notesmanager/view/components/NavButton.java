package com.cavenaire.notesmanager.view.components;

import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        setMinimumSize(new Dimension(getWidth(), 55));
        setIconTextGap(18);
        setHorizontalAlignment(SwingConstants.LEADING);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Satoshi Bold", Font.BOLD, 18));
        setBorder(new EmptyBorder(0, 33, 0, 0));

        putClientProperty("FlatLaf.style",
                "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; hoverBackground : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; pressedBackground : " + Palette.BACKGROUND_HEX);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

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
}
