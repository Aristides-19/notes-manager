package com.cavenaire.notesmanager.view.components.menus;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MenuTextField, it is used to perform search queries on menu tables and fields to create objects.
 */
@Getter
public class MenuTextField extends JPanel {

    public MenuTextField(FlatSVGIcon icon, String text) {
        super();

        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        this.searchButton = new JButton(icon);
        this.textField = new JTextField(text);
        this.defaultText = text;

        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 10 15 10 15"));
        setPreferredSize(SIZE);

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",1,10");

        add(textField, "push, grow");
        add(searchButton);
    }

    private void initComponents() {
        textField.setFont(FontPalette.H2_REG);
        textField.putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; foreground: " + Palette.TEXT_FIELD_HEX +
                "; border : 0,0,0,0" +
                "; selectionColor : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; selectedTextColor : " + Palette.TEXT_FIELD_HEX +
                "; caretColor : " + Palette.MAIN_HEX);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(defaultText);
                    textField.setForeground(Palette.TEXT_FIELD);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(defaultText)) {
                    textField.setText("");
                    textField.setForeground(Palette.MAIN);
                }
            }
        });

        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(CURSOR);
    }

    // VARIABLES
    private final String defaultText;
    // COMPONENTS
    private final JButton searchButton;
    private final JTextField textField;
    // COMMONS
    private static final Dimension SIZE = new Dimension(356, 0);
    private static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);
}
