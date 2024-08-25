package com.cavenaire.notesmanager.view.components.menus.textfield;

import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * It extends {@code MenuTextField} with an action icon to perform search queries.
 */
@Getter
public class SearchTextField extends MenuTextField {

    public SearchTextField(String text, int width, String... insets) {
        super(text, width, insets);
        this.actionIcon = new JButton(ICON);
        initIcon();
    }

    private void initIcon() {
        actionIcon.setContentAreaFilled(false);
        actionIcon.setFocusPainted(false);
        actionIcon.setBorderPainted(false);
        actionIcon.setCursor(CURSOR);
        add(actionIcon);
    }

    // COMPONENTS
    private final JButton actionIcon;

    // COMMONS
    private static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);
    private static final FlatSVGIcon ICON = new FlatSVGIcon("images/menus/search.svg").setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
}
