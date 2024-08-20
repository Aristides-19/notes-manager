package com.cavenaire.notesmanager.controller;

import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.view.observer.ErrorNotifier;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceHandler {

    @Getter
    private final ErrorNotifier viewErrorNotifier;
    private final Logger logger = LoggerFactory.getLogger(ServiceHandler.class);

    public void handleServiceCall(Runnable serviceCall, String viewMessage, String logMessage) {
        try {
            serviceCall.run();
        } catch (ServiceLayerException e) {
            viewErrorNotifier.notifyError(viewMessage);
            logger.error(logMessage, e);
        }
    }

}
