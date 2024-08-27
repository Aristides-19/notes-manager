package com.cavenaire.notesmanager.view.ui.dialogs;

import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.ui.MainUI;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog to show when there is an unexpected behavior on app.
 * It is simple as calling {@code onDialog} method and wait for the result. <br/>
 * If you choose {@code ACCEPT_OPTION} you can ignore the result since it will always be {@code true}.
 *
 * @see MainUI
 */
@Component
public class MainDialog extends JDialog {

    public MainDialog(MainUI mainUI) {
        super(mainUI, true);
        initButtons();
        initMessage();
        init();
    }

    public boolean onDialog(String message, int options) {
        this.message.setText(message);
        panel.remove(cancelButton);
        panel.remove(okButton);
        switch (options) {
            case ACCEPT_OPTION -> panel.add(okButton, "split 2, push, right, bottom, gapright 40, gapbottom 15");
            case ACCEPT_CANCEL_OPTION -> {
                panel.add(cancelButton, "split 2, push, right, bottom, gapright 40, gapbottom 15");
                panel.add(okButton, "bottom, gapright 30, gapbottom 15");
            }
        }
        setVisible(true);
        return isOkay;
    }

    private void init() {
        setMinimumSize(new Dimension(450, 163));
        setUndecorated(true);
        setLocationRelativeTo(null);
        add(panel);

        panel.setLayout(new MigLayout("insets 20 20 20 20"));
        panel.putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; border : 0,0,0,0," + Palette.BORDER_HEX + ",2");

        panel.add(icon, "center, split 2, pushx");
        panel.add(message, "growx, wrap");
        panel.add(cancelButton);
        panel.add(okButton);
    }

    private void initMessage() {
        message.setFont(FontPalette.H3_REG);
        message.putClientProperty("FlatLaf.style", "background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; foreground : " + Palette.MAIN_HEX +
                "; selectionColor : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; selectedTextColor : " + Palette.TEXT_FIELD_HEX);

        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setEditable(false);
    }

    private void initButtons() {
        cancelButton.setFont(FontPalette.H4_REG);
        okButton.setFont(FontPalette.H4_REG);

        var size = new Dimension(100, 27);
        cancelButton.setMinimumSize(size);
        okButton.setMinimumSize(size);

        String properties = "foreground : " + Palette.MAIN_HEX +
                "; background : " + Palette.SECONDARY_BACKGROUND_HEX +
                "; hoverBackground : " + Palette.BACKGROUND_HEX +
                "; pressedBackground : " + Palette.BACKGROUND_HEX;
        cancelButton.putClientProperty("FlatLaf.style", properties + "; border : 0,0,0,0," + Palette.ERROR_BORDER_HEX + ",1,8");
        okButton.putClientProperty("FlatLaf.style", properties + "; border : 0,0,0,0," + Palette.UNSELECT_HEX + ",1,8");

        var cursor = new Cursor(Cursor.HAND_CURSOR);
        cancelButton.setCursor(cursor);
        okButton.setCursor(cursor);

        okButton.addActionListener((e) -> {
            isOkay = true;
            setVisible(false);
        });
        cancelButton.addActionListener((e) -> {
            isOkay = false;
            setVisible(false);
        });
    }

    // VARIABLES
    private boolean isOkay;
    public static final int ACCEPT_OPTION = 0;
    public static final int ACCEPT_CANCEL_OPTION = 1;

    // COMPONENTS
    private final JPanel panel = new JPanel();
    private final JTextArea message = new JTextArea();
    private final JButton okButton = new JButton("Aceptar");
    private final JButton cancelButton = new JButton("Cancelar");
    private final JLabel icon = new JLabel(new FlatSVGIcon("images/dialogs/warning.svg")
            .setColorFilter(new FlatSVGIcon.ColorFilter().add(Color.BLACK, Palette.MAIN)));

}
