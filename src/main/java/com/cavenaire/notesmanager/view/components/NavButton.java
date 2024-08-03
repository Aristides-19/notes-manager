package com.cavenaire.notesmanager.view.components;

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
                "background : #FFFFFF;" +
                        "hoverBackground : #FFFFFF;" +
                        "pressedBackground : #F9F9F9");

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        icon.setColorFilter(colorFilter);
        setSelected(false);
    }

    @Override
    public void setSelected(boolean selected) {
        if (selected) {
            setForeground(selectedColor);
            colorFilter.add(Color.BLACK, selectedColor);
        } else {
            setForeground(unselectedColor);
            colorFilter.add(Color.BLACK, unselectedColor);
        }
        setIcon(icon);
    }

    private final FlatSVGIcon icon;
    private final Color selectedColor = new Color(22, 27, 70, 229);
    private final Color unselectedColor = new Color(22, 27, 70, 127);
    private final FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
}
