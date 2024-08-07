package com.cavenaire.notesmanager.view.menus;

import com.cavenaire.notesmanager.view.menus.dashboard.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * App Main Display, It contains every menu Panel. It takes care of moving between menus according to nav bar.
 *
 * @see com.cavenaire.notesmanager.view.menus.Display
 */
public class MainDisplay extends JPanel {

    public MainDisplay() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0"));
        add(dashboard, "push, grow, wmin 900");
    }

    // DISPLAY PANELS
    private final Display<TaskBar, Counters> dashboard = new Display<>(new TaskBar(), new Counters());
}
