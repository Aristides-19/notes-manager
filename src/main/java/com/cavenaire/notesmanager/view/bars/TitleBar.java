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
        // right-to-left so, left is right and right is left LOL
        setLayout(new MigLayout("rtl, insets 15 22 0 27",
                "[right]"));

        putClientProperty("FlatLaf.style", "background : " + Palette.BACKGROUND_HEX);

        add(close, "split 3, gapright 30");
        add(maximize, "gapright 34");
        add(minimize, "wrap");

        sep.putClientProperty("FlatLaf.style", "foreground : " + Palette.BORDER_HEX + "; stripeWidth : 10");
        add(sep, "push, growx, bottom");
    }

    // COMPONENTS
    private final TitleButton close = new TitleButton(new FlatSVGIcon("images/titlebar/close.svg"), TitleButton.ButtonType.CLOSE);
    private final TitleButton maximize = new TitleButton(new FlatSVGIcon("images/titlebar/maximize.svg"), TitleButton.ButtonType.MAXIMIZE, new FlatSVGIcon("images/titlebar/resize.svg"));
    private final TitleButton minimize = new TitleButton(new FlatSVGIcon("images/titlebar/minimize.svg"), TitleButton.ButtonType.MINIMIZE);
    private final JSeparator sep = new JSeparator();
}
