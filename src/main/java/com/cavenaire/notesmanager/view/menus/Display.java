package com.cavenaire.notesmanager.view.menus;

import com.cavenaire.notesmanager.view.observer.Observable;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Display Template for Main Display.
 * It is intended to be a template for a {@code menu panel}.
 * So, basically every menu must be divided in two {@code subpanels}, both will push and grow. <br/>
 * It implements a {@code ComponentShown} event to update {@code Observable} panels.
 *
 * @see com.cavenaire.notesmanager.view.menus.MainDisplay
 */
public class Display extends JPanel {

    public Display(JComponent top, JComponent bottom) {
        super();
        this.top = top;
        this.bottom = bottom;
        init();
    }

    private void init() {
        setLayout(new MigLayout("insets 0, flowy, gap 0"));

        add(top, "push, grow");
        add(bottom, "push, grow");
        setVisible(false);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (Observable.class.isAssignableFrom(top.getClass())) {
                    ((Observable<?>) top).update(null);
                }
                if (Observable.class.isAssignableFrom(bottom.getClass())) {
                    ((Observable<?>) bottom).update(null);
                }
            }
        });
    }

    // PANELS
    private final JComponent top;
    private final JComponent bottom;
}
