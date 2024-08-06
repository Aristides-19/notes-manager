package com.cavenaire.notesmanager.view.bars;

import com.cavenaire.notesmanager.view.components.NavButton;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.utils.SVGIcon;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.JPanel;

/**
 * Side Navigation Bar, it will be there in any showed frame, never disappears.
 *
 * @see com.cavenaire.notesmanager.view.components.NavButton
 */
public class NavBar extends JPanel {

    public NavBar() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 5px 0px 12px 0px, flowy", "[grow]", "[top]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,2," + Palette.BORDER_HEX + ",1,0");

        add(logo, "center, gap top 75px");
        add(menu, "center, gap top 75px, grow, pushx");
        add(invoice, "center, grow");
        add(notes, "center, grow");
        add(clients, "center, grow");

        add(settings, "center, growx, push, bottom");
        add(help, "center, grow");

        menu.setSelected(true);
    }

    // COMPONENTS
    private final SVGIcon logo = new SVGIcon("images/logo.svg", 219, 37);
    private final NavButton menu = new NavButton(new FlatSVGIcon("images/navbar/menu.svg"), "Menú");
    private final NavButton invoice = new NavButton(new FlatSVGIcon("images/navbar/invoice.svg"), "Facturas");
    private final NavButton notes = new NavButton(new FlatSVGIcon("images/navbar/notes.svg"), "Notas de Entrega");
    private final NavButton clients = new NavButton(new FlatSVGIcon("images/navbar/clients.svg"), "Clientes");
    private final NavButton settings = new NavButton(new FlatSVGIcon("images/navbar/settings.svg"), "Configuración");
    private final NavButton help = new NavButton(new FlatSVGIcon("images/navbar/help.svg"), "Ayuda");
}
