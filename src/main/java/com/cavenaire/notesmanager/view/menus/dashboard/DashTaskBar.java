package com.cavenaire.notesmanager.view.menus.dashboard;

import com.cavenaire.notesmanager.model.ClientModel;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.components.menus.dashboard.DashboardInfo;
import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.TitleLabel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
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

    public DashTaskBar(MenuButton addNote) {
        super();
        this.addNote = addNote;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 45 40 0 55", "", "[]10[]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(title, "aligny 50%, split 2");
        add(addNote, "gapleft push, wrap");
        add(dashboardInfo, "push, growx, gapleft 15");
    }

    // COMPONENTS
    private final TitleLabel title = new TitleLabel("¡Bienvenido!");
    private final MenuButton addNote;
    // THIS IS ONLY FOR TESTS
    private final DashboardInfo dashboardInfo = new DashboardInfo(new FlatSVGIcon("images/menus/dashboard/activity.svg"),
            new ClientModel() {
                @Override
                public void setName(String name) {

                }

                @Override
                public String getName() {
                    return "Arístides Pérez";
                }

                @Override
                public void setDocument(String document) {

                }

                @Override
                public String getDocument() {
                    return "V-31.912.844";
                }

                @Override
                public void setContact(String contact) {

                }

                @Override
                public String getContact() {
                    return "0424-2196251";
                }

                @Override
                public void setAddress(String address) {

                }

                @Override
                public String getAddress() {
                    return "Av. Francisco de Miranda, Edf. Los Ruices, Piso 11, Apto 112, Los Ruices, Dtto. Capital, Caracas";
                }

                @Override
                public void setLastDate(String lastDate) {

                }

                @Override
                public String getLastDate() {
                    return "";
                }

                @Override
                public int getID() {
                    return 0;
                }

                @Override
                public boolean isJuridical() {
                    return false;
                }

                @Override
                public boolean isNatural() {
                    return true;
                }
            });
}
