package com.cavenaire.notesmanager.view.components.menus.dashboard;

import com.cavenaire.notesmanager.model.ClientModel;
import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard Information Panel about Last Client
 */
public class DashboardInfo extends JPanel {

    public DashboardInfo(FlatSVGIcon icon, ClientModel client) {
        super();
        initComponents(icon, client);
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 25 34 25 34",
                "[]42[]0[]38[]", "[]10[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",1,15");

        add(icon, "push, al center center");
        add(title, "push, wrap");
        add(name, "push, skip");
        add(contact, "push");
        add(document, "push");
        add(address, "push");
    }

    private void initComponents(FlatSVGIcon icon, ClientModel client) {
        title.setText("Último Cliente");
        name.setText(getMultiText("Nombre", client.getName()));
        contact.setText(getMultiText("Contacto", client.getContact()));
        document.setText(getMultiText("Documento", client.getDocument()));
        address.setText(getMultiText("Dirección", truncateAddress(client.getAddress())));

        String style = "foreground : " + Palette.MAIN_HEX;

        title.putClientProperty("FlatLaf.style", style);
        name.putClientProperty("FlatLaf.style", style);
        contact.putClientProperty("FlatLaf.style", style);
        document.putClientProperty("FlatLaf.style", style);
        address.putClientProperty("FlatLaf.style", style);

        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        this.icon.setIcon(icon);

        title.setFont(FontPalette.H0);

    }

    private String getMultiText(String title, String info) {
        // HTML is only used here because it is the simplest way to get two fonts on the same JLabel
        return "<html><span style='font-family: " + FontPalette.FAMILY + "; font-weight: bold; font-size: 17pt;'>" +
                title + "</span><br><span style='font-family: " + FontPalette.FAMILY + "; font-size: 17pt;'>" +
                info + "</span></html>";
    }

    private String truncateAddress(String text) {
        if (text.length() <= 35) {
            return text;
        }
        return text.substring(0, 35) + "...";
    }

    // COMPONENTS
    private final JLabel icon = new JLabel();
    private final JLabel title = new JLabel();
    private final JLabel name = new JLabel();
    private final JLabel contact = new JLabel();
    private final JLabel document = new JLabel();
    private final JLabel address = new JLabel();
}
