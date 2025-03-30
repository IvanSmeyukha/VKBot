package com.justai.vkbot.service.impl;

import com.justai.vkbot.client.VKClient;
import com.justai.vkbot.dto.CallbackEvent;
import com.justai.vkbot.dto.MessageDto;
import com.justai.vkbot.dto.MessageNewEvent;
import com.justai.vkbot.service.VKEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageNewEventHandler implements VKEventHandler {
    private final VKClient vkClient;
    private final String ANSWER_PATTERN = "Вы написали: %s";
    private final String SUCCESS_RESPONSE_TEXT = "ok";

    @Override
    public String handle(CallbackEvent eventObject) {
        MessageNewEvent event = (MessageNewEvent) eventObject;
        MessageDto message = event.getMessage();
        vkClient.sendMessage(String.format(ANSWER_PATTERN, message.getText()), message.getFromId());
        return SUCCESS_RESPONSE_TEXT;
    }
}
