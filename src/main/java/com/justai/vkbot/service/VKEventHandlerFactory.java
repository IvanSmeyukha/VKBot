package com.justai.vkbot.service;

import com.justai.vkbot.enums.VKEventType;
import com.justai.vkbot.service.impl.ConfirmationEventHandler;
import com.justai.vkbot.service.impl.MessageNewEventHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VKEventHandlerFactory {
    private final Map<VKEventType, VKEventHandler> handlers = new HashMap<>();

    public VKEventHandlerFactory(
            MessageNewEventHandler messageNewEventHandler,
            ConfirmationEventHandler confirmationEventHandler
    ) {
        handlers.put(VKEventType.MESSAGE_NEW, messageNewEventHandler);
        handlers.put(VKEventType.CONFIRMATION, confirmationEventHandler);
    }

    public VKEventHandler getHandler(VKEventType eventType) {
        return handlers.get(eventType);
    }
}
