package com.cavenaire.notesmanager.view.ui;

import rob.camick.tools.ComponentResizer;
import rob.camick.tools.ComponentMover;

import com.cavenaire.notesmanager.view.utils.FontLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Main UI Window that contains MainPanel. It's undecorated and capable of resize.
 */
public class MainUI extends JFrame {

    public static void execute() {
        if (!SINGLETON) {
            SINGLETON = true;
            MAIN_FRAME = new MainUI();
        }
    }

    private MainUI() {
        super();
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
        MAIN_FRAME.setExtendedState(JFrame.ICONIFIED);
    }

    public static void setMaximized() {
        MAIN_FRAME.cr.deregisterComponent(MAIN_FRAME);
        MAIN_FRAME.setSize(screenSize.width, screenSize.height - taskBarSize);
        MAIN_FRAME.setLocation(0, 0);
    }

    public static void setResized() {
        MAIN_FRAME.initCResizer();
        MAIN_FRAME.setSize(1280, 800);
        MAIN_FRAME.setLocationRelativeTo(null);
    }

    // VARIABLES
    private final MainPanel mp = new MainPanel();
    private final ComponentResizer cr = new ComponentResizer(this);
    private final ComponentMover cm = new ComponentMover(JFrame.class, mp.getComponent(1));
    private static MainUI MAIN_FRAME;
    private static boolean SINGLETON = false;

    // WINDOW DIMENSIONS
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int taskBarSize = Toolkit
            .getDefaultToolkit()
            .getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration()).bottom;
}
