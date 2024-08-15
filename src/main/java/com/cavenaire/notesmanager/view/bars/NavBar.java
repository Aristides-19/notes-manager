package com.cavenaire.notesmanager.view.bars;

import com.cavenaire.notesmanager.view.components.bars.NavButton;
import com.cavenaire.notesmanager.view.bars.config.NavBarConfig;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Side Navigation Bar, it will be there in any showed frame, never disappears.
 *
 * @see NavButton
 * @see NavBarConfig
 */
@Component
public class NavBar extends JPanel {

    public NavBar(NavButton menuButton, NavButton invoicesButton, NavButton notesButton, NavButton clientsButton,
                  NavButton settingsButton, NavButton helpButton) {
        super();
        this.menu = menuButton;
        this.invoices = invoicesButton;
        this.notes = notesButton;
        this.clients = clientsButton;
        this.settings = settingsButton;
        this.help = helpButton;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 5px 0px 12px 0px, flowy", "[grow]", "[top]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,2," + Palette.BORDER_HEX + ",1,0");

        add(logo, "center, gap top 75px");
        add(menu, "center, gap top 75px, grow, pushx");
        add(invoices, "center, grow");
        add(notes, "center, grow");
        add(clients, "center, grow");

        add(settings, "center, growx, push, bottom");
        add(help, "center, grow");

        menu.setSelected();
    }

    // COMPONENTS
    private final JLabel logo = new JLabel(new FlatSVGIcon("images/logo.svg", 219, 37));
    private final NavButton menu;
    private final NavButton invoices;
    private final NavButton notes;
    private final NavButton clients;
    private final NavButton settings;
    private final NavButton help;
}
