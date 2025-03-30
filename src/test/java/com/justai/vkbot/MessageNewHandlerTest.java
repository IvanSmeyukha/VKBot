package com.justai.vkbot;

import com.justai.vkbot.client.VKClient;
import com.justai.vkbot.dto.*;
import com.justai.vkbot.service.impl.MessageNewEventHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {
        "vk.confirmation=12345",
        "vk.secret=test_secret",
        "vk.access-token=test_token"
})
public class MessageNewHandlerTest {
    @Autowired
    MessageNewEventHandler handler;
    @MockitoBean
    VKClient vkClient;

    @Test
    public void handleMessageNew() {
        CallbackEvent event = new MessageNewEvent(new ClientInfoDto(), new MessageDto("1", "тест"));
        when(vkClient.sendMessage(anyString(), anyString())).thenReturn("");

        String result = handler.handle(event);
        assertEquals("ok", result);
    }
}
