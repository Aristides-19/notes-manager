package com.cavenaire.notesmanager.view.components.bars;

import com.cavenaire.notesmanager.view.styles.Palette;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

/**
 * Title Bar Button to interact with Window closing and resizing.
 */
public class TitleButton extends JButton {

    public TitleButton(FlatSVGIcon icon) {
        super();

        icon.setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN));
        this.icon = icon;

        setIcon(icon);
        init();
    }

    public TitleButton(FlatSVGIcon maxIcon, FlatSVGIcon resizeIcon) {
        this(maxIcon);

        resizeIcon.setColorFilter(icon.getColorFilter());
        this.resizeIcon = resizeIcon;
        this.state = 0;
    }

    private void init() {
        setMinimumSize(SIZE);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBorder(BORDER);
        setContentAreaFilled(false);
        setCursor(CURSOR);
    }

    /**
     * Change icon to maximize/resize. It must be used only for maximized icon.
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
    @Getter
    @Setter
    private byte state;

    // ICONS
    private final FlatSVGIcon icon;
    private FlatSVGIcon resizeIcon;

    // COMMONS
    private static final Border BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    private static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);
    private static final Dimension SIZE = new Dimension(18, 18);
}
