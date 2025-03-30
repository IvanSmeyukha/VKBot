package com.justai.vkbot;

import com.justai.vkbot.client.VKClient;
import com.justai.vkbot.dto.CallbackDto;
import com.justai.vkbot.dto.ClientInfoDto;
import com.justai.vkbot.dto.MessageDto;
import com.justai.vkbot.dto.MessageNewEvent;
import com.justai.vkbot.enums.VKEventType;
import com.justai.vkbot.service.CallbackService;
import com.justai.vkbot.service.VKEventHandler;
import com.justai.vkbot.service.VKEventHandlerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {
        "vk.confirmation=12345",
        "vk.secret=test_secret",
        "vk.access-token=test_token"
})
public class CallbackServiceTest {
    @Autowired
    CallbackService callbackService;

    @Test
    public void handleInvalidSecret() {
        CallbackDto request = new CallbackDto(VKEventType.CONFIRMATION, "qqq", null);
        assertThrows(InvalidParameterException.class, () -> callbackService.handleCallback(request));
    }

}
