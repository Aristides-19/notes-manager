package com.cavenaire.notesmanager;

import com.cavenaire.notesmanager.view.ui.MainUI;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.SneakyThrows;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.awt.EventQueue;

@SpringBootApplication
public class App {

    static ApplicationContext context;

    @SneakyThrows
    public static void main(String[] args) {
        FlatLightLaf.setup();
        EventQueue.invokeAndWait(() -> context = new SpringApplicationBuilder(App.class).headless(false).web(WebApplicationType.NONE).run(args));
        EventQueue.invokeLater(() -> context.getBean(MainUI.class).setVisible(true));
    }
}
