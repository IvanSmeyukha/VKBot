package com.justai.vkbot.service.impl;

import com.justai.vkbot.dto.CallbackEvent;
import com.justai.vkbot.service.VKEventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationEventHandler implements VKEventHandler {
    @Value("${vk.confirmation}")
    private String confirmation;
    @Override
    public String handle(CallbackEvent eventObject) {
        return confirmation;
    }
}
