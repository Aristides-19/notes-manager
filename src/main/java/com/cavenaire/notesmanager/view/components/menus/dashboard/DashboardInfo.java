package com.cavenaire.notesmanager.view.components.menus.dashboard;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.view.observer.Observable;
import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard Information Panel about Last Client
 */
public class DashboardInfo extends JPanel implements Observable<Customer> {

    public DashboardInfo(FlatSVGIcon icon) {
        super();
        initComponents(icon);
        init();
    }

    @Override
    public void update(Customer customer) {
        try {
            name.setText(getMultiText("Nombre", truncateString(customer.getFullName(), 15)));
            contact.setText(getMultiText("Contacto", customer.getContact()));
            document.setText(getMultiText("Documento", customer.getDocument()));
            address.setText(getMultiText("Dirección", truncateString(customer.getAddress(), 35)));
            title.setText("Último Cliente");
        } catch (NullPointerException e) {
            title.setText("¡Agrega tu Primer Cliente!");
        }
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

    private void initComponents(FlatSVGIcon icon) {
        title.setText("Último Cliente");

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
        return info.isEmpty() ? "" : "<html><span style='font-family: " + FontPalette.FAMILY + "; font-weight: bold; font-size: 17pt;'>" +
                title + "</span><br><span style='font-family: " + FontPalette.FAMILY + "; font-size: 17pt;'>" +
                info + "</span></html>";
    }

    private String truncateString(String text, int length) {
        if (text.length() <= length) {
            return text;
        }
        return text.substring(0, length) + "...";
    }

    // COMPONENTS
    private final JLabel icon = new JLabel();
    private final JLabel title = new JLabel();
    private final JLabel name = new JLabel();
    private final JLabel contact = new JLabel();
    private final JLabel document = new JLabel();
    private final JLabel address = new JLabel();
}
