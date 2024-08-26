package com.cavenaire.notesmanager.view.components.menus.textfield;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * It uses {@code MenuTextField} with a title that gives information about the text field.<br/>
 * It is used in object creation fields.
 */
@Getter
public class EntityAttrTextField extends JPanel {

    public EntityAttrTextField(String title, boolean required, String placeholder) {
        var field = new MenuTextField(placeholder, 0, "15", "15", "15", "15");
        this.field = field.getField();
        this.placeholder = field.getPlaceholder();
        this.required = required;
        this.title = new JLabel(getMultiColorText(title, required));
        init(field);
    }

    private void init(MenuTextField field) {
        setLayout(new MigLayout());
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);
        add(title, "gapleft 2, wrap");
        add(field, "pushx, grow");
    }

    private String getMultiColorText(String title, boolean required) {
        var html = "<html><span style='font-family: " + FontPalette.FAMILY + "; font-weight: regular; font-size: 17pt; color: " + Palette.MAIN_HEX + ";'>" + title + "</span>";
        html += required ? "<span style='font-family: " + FontPalette.FAMILY + "; font-weight: regular; font-size: 17pt; color: red;'> *</span></html>" : "</html>";
        return html;
    }

    // COMPONENTS
    private final JLabel title;
    private final String placeholder;
    private final JTextField field;
    private final boolean required;
}
