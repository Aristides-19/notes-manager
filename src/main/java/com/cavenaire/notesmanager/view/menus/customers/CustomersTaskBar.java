package com.cavenaire.notesmanager.view.menus.customers;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.TitleLabel;
import com.cavenaire.notesmanager.view.styles.Palette;
import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Shows the customers menu title and a button to export customers.
 */
@Component
public class CustomersTaskBar extends JPanel {

    public CustomersTaskBar(MenuButton exportCustomers) {
        super();
        this.exportCustomers = exportCustomers;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 10 30 10 40"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(title, "aligny 50%, split 2, push");
        add(exportCustomers, "gapleft push");
    }

    // COMPONENTS
    private final TitleLabel title = new TitleLabel("Administra tus Clientes");
    private final MenuButton exportCustomers;
}
