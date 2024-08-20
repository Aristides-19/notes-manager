package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardInfo;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.TitleLabel;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * This Panel shows information about the latest client and action button
 *
 * @see DashboardInfo
 * @see MenuButton
 */
@Component
public class DashTaskBar extends JPanel {

    public DashTaskBar(MenuButton addNote, DashboardInfo latestCustomerInfo) {
        super();
        this.addNote = addNote;
        this.latestCustomerInfo = latestCustomerInfo;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 45 40 0 55", "", "[]10[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(title, "aligny 50%, split 2");
        add(addNote, "gapleft push, wrap");
        add(latestCustomerInfo, "push, growx, gapleft 15");
    }

    // COMPONENTS
    private final TitleLabel title = new TitleLabel("¡Bienvenido!");
    private final MenuButton addNote;
    private final DashboardInfo latestCustomerInfo;
}
