package com.cavenaire.notesmanager.view.components.menus.dashboard;

import com.cavenaire.notesmanager.view.observer.Observable;
import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Dashboard Counter Panel, it shows a counter for specified info.
 */
public class DashboardCounter extends JPanel implements Observable<Integer> {

    public DashboardCounter(FlatSVGIcon icon, String text) {
        super();
        initComponents(icon, text);
        init();
    }

    @Override
    public void update(Integer count) {
        counter.setText(String.valueOf(count));
    }

    private void init() {
        setLayout(new MigLayout("flowy, al center center",
                "[center]", "[]15[]3[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",1,15");

        add(icon);
        add(counter);
        add(text);
    }

    private void initComponents(FlatSVGIcon icon, String text) {
        this.text.setText(text);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        String style = "foreground : " + Palette.MAIN_HEX;

        this.icon.setIcon(icon);
        this.counter.putClientProperty("FlatLaf.style", style);
        this.text.putClientProperty("FlatLaf.style", style);

        this.counter.setFont(FontPalette.H0);
        this.text.setFont(FontPalette.H2_REG);

        this.icon.setBorder(BORDER);
        this.counter.setBorder(BORDER);
        this.text.setBorder(BORDER);

    }

    // COMPONENTS
    private final JLabel counter = new JLabel();
    private final JLabel text = new JLabel();
    private final JLabel icon = new JLabel();

    // COMMONS
    private static final Border BORDER = BorderFactory.createEmptyBorder(0, 10, 0, 0);
}
