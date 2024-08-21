package com.cavenaire.notesmanager.view.ui;

import org.springframework.stereotype.Component;
import rob.camick.tools.ComponentResizer;
import rob.camick.tools.ComponentMover;

import com.cavenaire.notesmanager.view.utils.FontLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Main UI Window that contains MainPanel.
 *
 * @see com.cavenaire.notesmanager.view.ui.MainPanel
 * @see com.cavenaire.notesmanager.view.utils.FontLoader
 */
@Component
public class MainUI extends JFrame {

    public MainUI(MainPanel mp) {
        super("Cavenaire Manager");
        this.mp = mp;
        this.cm = new ComponentMover(JFrame.class, mp.getComponent(1));
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 800);
    
        setIconImage(Toolkit.getDefaultToolkit().createImage(ClassLoader.getSystemResource("images/icon.png")));

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

    public void setMinimized() {
        setExtendedState(JFrame.ICONIFIED);
    }

    public void setMaximized() {
        cr.deregisterComponent(this);
        setSize(WIDTH, HEIGHT);
        setLocation(0, 0);
    }

    public void setResized() {
        cr.registerComponent(this);
        setSize(1280, 800);
        setLocationRelativeTo(null);
    }

    // VARIABLES
    private final MainPanel mp;
    private final ComponentMover cm;
    private final ComponentResizer cr = new ComponentResizer(this);

    // WINDOW MAXIMIZED DIMENSIONS
    private static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - Toolkit.getDefaultToolkit()
            .getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration()).bottom;
}
