package com.cavenaire.notesmanager.view.components.menus.textfield;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MenuTextField, it is a component with basic text field functionality.<br/>
 * It is intended to be extended for implementations like fields with title, or a search field.
 */
@Getter
class MenuTextField extends JPanel {

    public MenuTextField(String placeholder, int width, String... insets) {
        super();

        this.field = new JTextField(placeholder);
        this.placeholder = placeholder;

        initTextField();
        init(width, insets);
    }

    public void showErrorBorder() {
        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.ERROR_BORDER_HEX + ",2,10");
    }

    public void showRegularBorder() {
        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",1,10");
    }

    private void init(int width, String... insets) {
        setLayout(new MigLayout("insets " + insets[0] + " " + insets[1] + " " + insets[2] + " " + insets[3]));
        setPreferredSize(new Dimension(width, 0));
        showRegularBorder();

        add(field, "push, grow");
    }

    private void initTextField() {
        field.setFont(FontPalette.H2_REG);
        field.putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; foreground: " + Palette.TEXT_FIELD_HEX +
                "; border : 0,0,0,0" +
                "; selectionColor : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; selectedTextColor : " + Palette.TEXT_FIELD_HEX +
                "; caretColor : " + Palette.MAIN_HEX);

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Palette.TEXT_FIELD);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Palette.MAIN);
                }
            }
        });
    }

    // COMPONENTS
    private final String placeholder;
    private final JTextField field;
}
