package com.cavenaire.notesmanager.view.bars;

import com.cavenaire.notesmanager.view.components.bars.TitleButton;
import com.cavenaire.notesmanager.view.bars.config.TitleBarConfig;
import com.cavenaire.notesmanager.view.styles.Palette;

import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Title Bar, it brings the capability to close, minimize and maximize window App.
 *
 * @see TitleButton
 * @see TitleBarConfig
 */
@Component
public class TitleBar extends JPanel {

    public TitleBar(TitleButton close, TitleButton maximize, TitleButton minimize) {
        super();
        this.close = close;
        this.maximize = maximize;
        this.minimize = minimize;
        init();
    }

    private void init() {
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
    private final TitleButton close;
    private final TitleButton maximize;
    private final TitleButton minimize;
    private final JSeparator sep = new JSeparator();
}
