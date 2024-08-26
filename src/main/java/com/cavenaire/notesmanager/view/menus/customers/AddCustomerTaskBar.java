package com.cavenaire.notesmanager.view.menus.customers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.SubtitleLabel;
import com.cavenaire.notesmanager.view.components.menus.TitleLabel;
import com.cavenaire.notesmanager.view.styles.Palette;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AddCustomerTaskBar extends JPanel {

    public AddCustomerTaskBar(SubtitleLabel addEntitySubtitle, MenuButton goBackCustomers) {
        this.addEntitySubtitle = addEntitySubtitle;
        this.goBackCustomers = goBackCustomers;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 40 50 0 55", "", "[]10[]"));
        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(title, "split 2, aligny 50%");
        add(goBackCustomers, "gapleft push, wrap");
        add(addEntitySubtitle, "push, gapleft 20");
    }

    // COMPONENTS
    private final TitleLabel title = new TitleLabel("Añade un Nuevo Cliente");
    private final SubtitleLabel addEntitySubtitle;
    private final MenuButton goBackCustomers;
}
