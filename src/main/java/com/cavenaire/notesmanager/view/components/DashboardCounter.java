package com.cavenaire.notesmanager.view.components;

import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard Counter Panel, it shows a counter for specified info.
 */
public class DashboardCounter extends JPanel {

    public DashboardCounter(FlatSVGIcon icon, String text, String initialCount) {
        super();
        initComponents(icon, text, initialCount);
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",1,15");

        add(Box.createVerticalGlue());
        add(this.icon);
        add(Box.createVerticalStrut(20));
        add(this.counter);
        add(Box.createVerticalStrut(5));
        add(this.text);
        add(Box.createVerticalGlue());
    }

    private void initComponents(FlatSVGIcon icon, String text, String initialCount) {
        this.counter.setText(initialCount);
        this.text.setText(text);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));

        String style = "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; foreground : " + Palette.MAIN_HEX;

        this.icon.setIcon(icon);
        this.counter.putClientProperty("FlatLaf.style", style);
        this.text.putClientProperty("FlatLaf.style", style);

        this.counter.setFont(COUNTER_FONT);
        this.text.setFont(TEXT_FONT);

        this.icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.counter.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.text.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.counter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        this.text.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    }

    // COMPONENTS
    private final JLabel counter = new JLabel();
    private final JLabel text = new JLabel();
    private final JLabel icon = new JLabel();

    // COMMONS
    private static final Font COUNTER_FONT = new Font("Satoshi Bold", Font.BOLD, 24);
    private static final Font TEXT_FONT = new Font("Satoshi Regular", Font.PLAIN, 17);
}
