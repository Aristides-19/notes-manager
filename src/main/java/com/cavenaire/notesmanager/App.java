package com.cavenaire.notesmanager;

import com.cavenaire.notesmanager.view.ui.MainUI;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

public class App {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        EventQueue.invokeLater(() -> new MainUI().setVisible(true));
    }
}
