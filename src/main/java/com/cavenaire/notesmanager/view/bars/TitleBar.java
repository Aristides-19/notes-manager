package com.cavenaire.notesmanager.view.bars;

import com.cavenaire.notesmanager.view.components.TitleButton;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Title Bar, it brings the capability to close, minimize and maximize window App.
 */
public class TitleBar extends JPanel {

    public TitleBar() {
        super();
        init();
    }

    private void init() {
        setLayout(new MigLayout("rtl, insets 20 27 0 27",
                "[right]", ""));

        add(close, "split 3, gapright 30");
        add(maximize, "gapright 34");
        add(minimize, "wrap");

        sep.putClientProperty("FlatLaf.style", "foreground : " + Palette.BORDER_HEX + "; stripeWidth : 10");
        add(sep, "push, growx, bottom");
    }

    // COMPONENTS
    private final TitleButton close = new TitleButton(new FlatSVGIcon("images/TitleBar/Close.svg"), TitleButton.ButtonType.CLOSE);
    private final TitleButton maximize = new TitleButton(new FlatSVGIcon("images/TitleBar/Maximize.svg"), TitleButton.ButtonType.MAXIMIZE, new FlatSVGIcon("images/TitleBar/Resize.svg"));
    private final TitleButton minimize = new TitleButton(new FlatSVGIcon("images/TitleBar/Minimize.svg"), TitleButton.ButtonType.MINIMIZE);
    private final JSeparator sep = new JSeparator();
}
