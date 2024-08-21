package com.cavenaire.notesmanager.view.utils;

import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * IconLoader static class to load icon.
 */
public class IconLoader {

    static public Image loadIcon() {

        try (InputStream iconStream = IconLoader.class.getClassLoader().getResourceAsStream("images/icon.png")) {

            BufferedImage buffIcon = ImageIO.read(Objects.requireNonNull(iconStream));
            return new ImageIcon(buffIcon).getImage();

        } catch (NullPointerException | IOException e) {
            LoggerFactory.getLogger(IconLoader.class).warn("Icon cannot be loaded", e);
        }

        return new ImageIcon().getImage();
    }
}
