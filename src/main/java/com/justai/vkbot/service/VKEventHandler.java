package com.justai.vkbot.service;

import com.justai.vkbot.dto.CallbackEvent;

public interface VKEventHandler {
    String handle(CallbackEvent eventObject);
}
