package com.cavenaire.notesmanager.view.menus.config;

import com.cavenaire.notesmanager.view.components.menus.MenuButton;
import com.cavenaire.notesmanager.view.components.menus.SubtitleLabel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configurates menu buttons as beans, connecting them to handlers.
 * Some buttons appear in more than one menu, providing them as beans assure that
 * there is only one button object across the application.
 */
@Configuration
public class MenuConfig {

    @Bean
    public MenuButton addNote() {
        return new MenuButton(new FlatSVGIcon("images/menus/add.svg"), "Nueva Nota", 12);
    }

    @Bean
    public SubtitleLabel addEntitySubtitle() {
        return new SubtitleLabel(new FlatSVGIcon("images/menus/arrow-right.svg"), "Recuerda llenar los campos correctamente", 30);
    }
}
