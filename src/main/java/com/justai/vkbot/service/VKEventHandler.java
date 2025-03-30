package com.justai.vkbot.service;

import com.justai.vkbot.dto.CallbackEvent;

/**
 * Service for event handling
 */
public interface VKEventHandler {
    /**
     * Handle event
     *
     * @param eventObject event object
     * @return handling result
     */
    String handle(CallbackEvent eventObject);
}
