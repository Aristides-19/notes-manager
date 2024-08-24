package com.cavenaire.notesmanager.view.handlers;

import com.cavenaire.notesmanager.view.components.bars.TitleButton;
import com.cavenaire.notesmanager.view.ui.MainUI;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Title Buttons Event Handling
 *
 * @see com.cavenaire.notesmanager.view.ui.MainUI
 * @see TitleButton
 */
@Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
@Component
public class TitleBarHandler {

    private MainUI mainUI;

    public void initHandler(TitleButton b, String type) {
        switch (type) {
            case "close" -> b.addActionListener(e -> onClose());
            case "maximize" -> b.addActionListener(e -> {
                b.changeIconState();
                if (b.getState() == 0) {
                    onMaximize();
                    b.setState((byte) 1);
                } else {
                    onResized();
                    b.setState((byte) 0);
                }
            });
            case "minimize" -> b.addActionListener(e -> onMinimize());
        }
    }

    private void onClose() {
        System.exit(0);
    }

    private void onMaximize() {
        mainUI.setMaximized();
    }

    private void onResized() {
        mainUI.setResized();
    }

    private void onMinimize() {
        mainUI.setMinimized();
    }
}
