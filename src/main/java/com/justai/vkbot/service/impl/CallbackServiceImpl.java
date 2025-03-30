package com.justai.vkbot.service.impl;

import com.justai.vkbot.service.VKEventHandler;
import com.justai.vkbot.service.VKEventHandlerFactory;
import com.justai.vkbot.dto.CallbackDto;
import com.justai.vkbot.service.CallbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@Slf4j
@RequiredArgsConstructor
public class CallbackServiceImpl implements CallbackService {
    private final VKEventHandlerFactory handlerFactory;
    @Value("${vk.secret}")
    private String secret;

    @Override
    public String handleCallback(CallbackDto request) {
        validateSecret(request.getSecret());
        VKEventHandler handler = handlerFactory.getHandler(request.getType());
        if (handler == null) {
            throw new UnsupportedOperationException("unsupported_event_type");
        }
        return handler.handle(request.getObject());
    }

    private void validateSecret(String requestSecret) {
        if (secret.equals(requestSecret)) {
            throw new InvalidParameterException("invalid_secret");
        }
    }
}
