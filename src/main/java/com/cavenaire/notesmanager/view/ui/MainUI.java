package com.cavenaire.notesmanager.view.ui;

import rob.camick.tools.ComponentResizer;
import rob.camick.tools.ComponentMover;

import com.cavenaire.notesmanager.view.utils.FontLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Singleton Main UI Window that contains MainPanel.
 *
 * @see com.cavenaire.notesmanager.view.ui.MainPanel
 * @see com.cavenaire.notesmanager.view.utils.FontLoader
 */
public class MainUI extends JFrame {

    public static void execute() {
        INSTANCE = INSTANCE == null ? new MainUI() : null;
    }

    private MainUI() {
        super("Cavenaire Manager");
        init();
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 800);

        setLocationRelativeTo(null);
        setUndecorated(true);

        cm.setChangeCursor(false);
        initCResizer();

        FontLoader.loadFonts();

        add(mp);
    }

    private void initCResizer() {
        cr.setMinimumSize(new Dimension(960, 600));
        cr.setMaximumSize(new Dimension(1280, 800));
        cr.setSnapSize(new Dimension(1, 1));
    }

    public static void setMinimized() {
        INSTANCE.setExtendedState(JFrame.ICONIFIED);
    }

    public static void setMaximized() {
        INSTANCE.cr.deregisterComponent(INSTANCE);
        INSTANCE.setSize(screenSize.width, screenSize.height - taskBarSize);
        INSTANCE.setLocation(0, 0);
    }

    public static void setResized() {
        INSTANCE.cr.registerComponent(INSTANCE);
        INSTANCE.setSize(1280, 800);
        INSTANCE.setLocationRelativeTo(null);
    }

    // VARIABLES
    private final MainPanel mp = new MainPanel();
    private final ComponentResizer cr = new ComponentResizer(this);
    private final ComponentMover cm = new ComponentMover(JFrame.class, mp.getComponent(1));
    private static MainUI INSTANCE;

    // WINDOW DIMENSIONS
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int taskBarSize = Toolkit
            .getDefaultToolkit()
            .getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration()).bottom;
}
