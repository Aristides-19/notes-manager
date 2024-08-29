package com.cavenaire.notesmanager.view.components.menus.textfield;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;

/**
 * It is a {@code MenuTextField} with a title that gives information about the text field
 * and two (no more or less) optionals {@code RadioButton}.<br/>
 * It is used in object creation fields.
 */
public class EntityAttrTextField extends JPanel {

    public EntityAttrTextField(String title, boolean required, String placeholder, String... radioButtons) {
        this.menuTextField = new MenuTextField(placeholder, 0, "15", "15", "15", "15");
        this.required = required;
        this.title = new JLabel(getMultiColorText(title, required));
        if (radioButtons[0] != null) {
            this.firstRadButton = new JRadioButton(radioButtons[0]);
            this.secondRadButton = new JRadioButton(radioButtons[1]);
            initRadButtons();
        }
        init();
    }

    public EntityAttrTextField(String title, boolean required, String placeholder) {
        this(title, required, placeholder, null, null);
    }

    public String getSelected() {
        if (firstRadButton != null) return firstRadButton.isSelected() ? firstRadButton.getText() : secondRadButton.getText();
        return "";
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
        if (firstRadButton != null) {
            add(title, "gapleft 2");
            add(firstRadButton, "split 2, pushx, right");
            add(secondRadButton, "wrap, gapright 10");
            add(menuTextField, "pushx, grow, span 2 1");
        } else {
            add(title, "gapleft 2, wrap");
            add(menuTextField, "pushx, grow");
        }
    }

    private void initRadButtons() {
        firstRadButton.setFont(FontPalette.H2_REG);
        secondRadButton.setFont(FontPalette.H2_REG);
        var cursor = new Cursor(Cursor.HAND_CURSOR);
        firstRadButton.setCursor(cursor);
        secondRadButton.setCursor(cursor);
        String properties = "foreground : " + Palette.MAIN_HEX +
                "; icon.borderColor : " + Palette.MAIN_HEX +
                "; icon.selectedBorderColor : " + Palette.MAIN_HEX +
                "; icon.hoverBorderColor : " + Palette.MAIN_HEX +
                "; icon.pressedBorderColor : " + Palette.MAIN_HEX +
                "; icon.focusedBorderColor : " + Palette.MAIN_HEX +
                "; icon.background : " + Palette.BACKGROUND_HEX +
                "; icon.selectedBackground : " + Palette.BACKGROUND_HEX +
                "; icon.hoverBackground : " + Palette.BACKGROUND_HEX +
                "; icon.pressedBackground : " + Palette.BACKGROUND_HEX +
                "; icon.focusedBackground : " + Palette.BACKGROUND_HEX +
                "; icon.checkmarkColor : " + Palette.MAIN_HEX +
                "; icon.borderWidth : 1" +
                "; icon.centerDiameter : 10" +
                "; icon.focusColor : " + Palette.MAIN_HEX;
        firstRadButton.putClientProperty("FlatLaf.style", properties);
        secondRadButton.putClientProperty("FlatLaf.style", properties);
        firstRadButton.setSelected(true);
        firstRadButton.addActionListener(e -> secondRadButton.setSelected(false));
        secondRadButton.addActionListener(e -> firstRadButton.setSelected(false));
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
    private JRadioButton firstRadButton;
    private JRadioButton secondRadButton;
}
