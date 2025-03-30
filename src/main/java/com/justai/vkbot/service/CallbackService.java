package com.justai.vkbot.service;

import com.justai.vkbot.dto.CallbackDto;

public interface CallbackService {
    String handleCallback(CallbackDto request);
}
