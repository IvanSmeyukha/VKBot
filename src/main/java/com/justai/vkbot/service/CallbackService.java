package com.justai.vkbot.service;

import com.justai.vkbot.dto.CallbackDto;

/**
 * Service for callback handling
 */
public interface CallbackService {
    /**
     * Handle callback request
     *
     * @param request request object from callback
     * @return handling result
     */
    String handleCallback(CallbackDto request);
}
