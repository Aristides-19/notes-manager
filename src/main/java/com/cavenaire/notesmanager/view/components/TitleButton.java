package com.cavenaire.notesmanager.view.components;

import com.cavenaire.notesmanager.view.handlers.TitleButtonHandler;
import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

/**
 * Title Bar Button to interact with Window closing and resizing.
 */
public class TitleButton extends JButton {

    public TitleButton(FlatSVGIcon icon, ButtonType type) {
        super();

        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        this.icon = icon;
        this.type = type;

        setIcon(icon);
        init();
        initHandler();
    }

    public TitleButton(FlatSVGIcon maxIcon, ButtonType type, FlatSVGIcon resizeIcon) {
        this(maxIcon, type);

        resizeIcon.setColorFilter(icon.getColorFilter());
        this.resizeIcon = resizeIcon;
        this.state = 0;
    }

    private void init() {
        setMinimumSize(new Dimension(18, 18));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBorder(new EmptyBorder(0, 0, 0, 0));

        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void initHandler() {
        TitleButton button = this;
        addActionListener(e -> {
            switch (type) {
                case CLOSE:
                    TitleButtonHandler.onClose();
                    break;
                case MAXIMIZE:
                    button.changeIconState();
                    if (state == 0) {
                        TitleButtonHandler.onMaximize();
                        state = 1;
                    } else {
                        TitleButtonHandler.onResized();
                        state = 0;
                    }
                    break;
                case MINIMIZE:
                    TitleButtonHandler.onMinimize();
                    break;
            }
        });
    }

    /**
     * Change icon to maximize/resize. It must be used only for maximize icon.
     *
     * @throws NullPointerException if resize icon is{@code null}.
     */
    public void changeIconState() {
        Objects.requireNonNull(resizeIcon, "resizeIcon is null");
        if (state == 0) {
            setIcon(resizeIcon);
        } else {
            setIcon(icon);
        }
    }

    // VARIABLES
    private final ButtonType type;
    private byte state;

    public enum ButtonType {CLOSE, MAXIMIZE, MINIMIZE}

    // ICONS
    private final FlatSVGIcon icon;
    private FlatSVGIcon resizeIcon;
}
