package com.cavenaire.notesmanager.view.bars;

import com.cavenaire.notesmanager.view.components.NavButton;
import com.cavenaire.notesmanager.view.utils.SVGIcon;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.JPanel;

/**
 * Side Navigation Bar, it'll be there in any showed frame, never disappears.
 */
public class NavBar extends JPanel {

    public NavBar() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 5px 0px 12px 0px, flowy", "[grow]", "[top]"));

        putClientProperty("FlatLaf.style", "background : #FFFFFF");

        add(logo, "center, gap top 75px");
        add(menu, "center, gap top 75px, grow, pushx");
        add(invoice, "center, grow");
        add(notes, "center, grow");
        add(clients, "center, grow");

        add(settings, "center, growx, push, bottom");
        add(help, "center, grow");

        clients.setSelected(true);
    }

    private final SVGIcon logo = new SVGIcon("images/Logo.svg", 219, 37);
    private final NavButton menu = new NavButton(new FlatSVGIcon("images/navBar/Menu.svg", 25, 25), "Menú");
    private final NavButton invoice = new NavButton(new FlatSVGIcon("images/navBar/Invoice.svg", 25, 25), "Facturas");
    private final NavButton notes = new NavButton(new FlatSVGIcon("images/navBar/Notes.svg", 25, 25), "Notas de Entrega");
    private final NavButton clients = new NavButton(new FlatSVGIcon("images/navBar/Clients.svg", 25, 25), "Clientes");
    private final NavButton settings = new NavButton(new FlatSVGIcon("images/navBar/Settings.svg", 25, 25), "Configuración");
    private final NavButton help = new NavButton(new FlatSVGIcon("images/navBar/Help.svg", 25, 25), "Ayuda");
}
