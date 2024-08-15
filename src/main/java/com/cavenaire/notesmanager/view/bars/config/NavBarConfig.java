package com.cavenaire.notesmanager.view.bars.config;

import com.cavenaire.notesmanager.view.components.bars.NavButton;
import com.cavenaire.notesmanager.view.handlers.NavBarHandler;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configurates navigation bar buttons as beans, connecting them to handlers.
 *
 * @see NavBarHandler
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Configuration
public class NavBarConfig {

    private NavBarHandler handler;

    private void setEvent(NavButton b, String type) {
        handler.initHandler(b, type);
    }

    @Bean
    public NavButton menuButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/menu.svg"), "Menú");
        setEvent(b, "menu");
        return b;
    }

    @Bean
    public NavButton invoicesButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/invoice.svg"), "Facturas");
        setEvent(b, "invoices");
        return b;
    }

    @Bean
    public NavButton notesButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/notes.svg"), "Notas de Entrega");
        setEvent(b, "notes");
        return b;
    }

    @Bean
    public NavButton clientsButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/clients.svg"), "Clientes");
        setEvent(b, "clients");
        return b;
    }

    @Bean
    public NavButton settingsButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/settings.svg"), "Configuración");
        setEvent(b, "settings");
        return b;
    }

    @Bean
    public NavButton helpButton() {
        var b = new NavButton(new FlatSVGIcon("images/navbar/help.svg"), "Ayuda");
        setEvent(b, "help");
        return b;
    }
}
