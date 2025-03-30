package com.justai.vkbot;

import com.justai.vkbot.dto.*;
import com.justai.vkbot.service.impl.ConfirmationEventHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {
        "vk.confirmation=12345",
        "vk.secret=test_secret",
        "vk.access-token=test_token"
})
public class ConfirmationEventTest {
    @Autowired
    ConfirmationEventHandler handler;

    @Test
    public void handleConfirmation() {
        String result = handler.handle(new ConfirmationEvent());
        assertEquals("12345", result);
    }
}
