package com.cavenaire.notesmanager.view.components.menus.textfield;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

/**
 * It is a {@code MenuTextField} with a title that gives information about the text field.<br/>
 * It is used in object creation fields.
 */
public class EntityAttrTextField extends JPanel {

    public EntityAttrTextField(String title, boolean required, String placeholder) {
        this.menuTextField = new MenuTextField(placeholder, 0, "15", "15", "15", "15");
        this.required = required;
        this.title = new JLabel(getMultiColorText(title, required));
        init();
    }

    public void resetField() {
        if (required) {
            menuTextField.showErrorBorder();
        } else {
            menuTextField.showRegularBorder();
        }
        menuTextField.placeholderMode();
    }

    public void showDefaultText(String defaultText) {
        menuTextField.writingMode();
        menuTextField.setText(defaultText);
    }

    public String getText() {
        return menuTextField.getText();
    }

    public void setText(String text) {
        menuTextField.setText(text);
    }

    public void addActionListener(ActionListener l) {
        menuTextField.addActionListener(l);
    }

    public void addFocusListener(FocusListener l) {
        menuTextField.addFocusListener(l);
    }

    public void showErrorBorder() {
        menuTextField.showErrorBorder();
    }

    public void showRegularBorder() {
        menuTextField.showRegularBorder();
    }

    public boolean isOnPlaceholder() {
        return menuTextField.isOnPlaceholder();
    }

    public boolean isOnError() {
        return menuTextField.isOnError();
    }

    private void init() {
        setLayout(new MigLayout());
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
        add(title, "gapleft 2, wrap");
        add(menuTextField, "pushx, grow");
    }

    private String getMultiColorText(String title, boolean required) {
        var html = "<html><span style='font-family: " + FontPalette.FAMILY + "; font-weight: regular; font-size: 17pt; color: " + Palette.MAIN_HEX + ";'>" + title + "</span>";
        html += required ? "<span style='font-family: " + FontPalette.FAMILY + "; font-weight: regular; font-size: 17pt; color: red;'> *</span></html>" : "</html>";
        return html;
    }

    // COMPONENTS
    private final MenuTextField menuTextField;
    private final JLabel title;
    @Getter
    private final boolean required;
}
