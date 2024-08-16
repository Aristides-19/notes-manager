package com.cavenaire.notesmanager.view.utils;

import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * FontLoader static class to load Satoshi variants font.
 */
public class FontLoader {

    /**
     * It loads every font needed in the project. It output a {@code ERROR} log if a font didn't load.
     */
    static public void loadFonts() {

        try (InputStream boldStream = FontLoader.class.getClassLoader().getResourceAsStream("fonts/Satoshi-Bold.otf");
             InputStream mediumStream = FontLoader.class.getClassLoader().getResourceAsStream("fonts/Satoshi-Medium.otf");
             InputStream regularStream = FontLoader.class.getClassLoader().getResourceAsStream("fonts/Satoshi-Regular.otf")) {

            Font bold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(boldStream));
            Font medium = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(mediumStream));
            Font regular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(regularStream));

            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(bold);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(medium);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(regular);

        } catch (IOException | FontFormatException e) {
            LoggerFactory.getLogger(FontLoader.class).error("Font cannot be loaded", e);
        }

    }
}
