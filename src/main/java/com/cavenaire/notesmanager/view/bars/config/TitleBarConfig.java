package com.cavenaire.notesmanager.view.bars.config;

import com.cavenaire.notesmanager.view.components.bars.TitleButton;
import com.cavenaire.notesmanager.view.handlers.TitleBarHandler;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configurates title bar buttons as beans, connecting them to handlers.
 *
 * @see TitleBarHandler
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Configuration
public class TitleBarConfig {

    private TitleBarHandler handler;

    private void setEvent(TitleButton b, String type) {
        handler.initHandler(b, type);
    }

    @Bean
    public TitleButton close() {
        var b = new TitleButton(new FlatSVGIcon("images/titlebar/close.svg"));
        setEvent(b, "close");
        return b;
    }

    @Bean
    public TitleButton maximize() {
        var b = new TitleButton(new FlatSVGIcon("images/titlebar/maximize.svg"), new FlatSVGIcon("images/titlebar/resize.svg"));
        setEvent(b, "maximize");
        return b;
    }

    @Bean
    public TitleButton minimize() {
        var b = new TitleButton(new FlatSVGIcon("images/titlebar/minimize.svg"));
        setEvent(b, "minimize");
        return b;
    }
}
