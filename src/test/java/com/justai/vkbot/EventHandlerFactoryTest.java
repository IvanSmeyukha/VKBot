package com.justai.vkbot;

import com.justai.vkbot.enums.VKEventType;
import com.justai.vkbot.service.VKEventHandlerFactory;
import com.justai.vkbot.service.impl.ConfirmationEventHandler;
import com.justai.vkbot.service.impl.MessageNewEventHandler;
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
public class EventHandlerFactoryTest {
    @Autowired
    VKEventHandlerFactory factory;

    @Test
    public void testConfirmationFactory() {
        assertEquals(ConfirmationEventHandler.class, factory.getHandler(VKEventType.CONFIRMATION).getClass());
    }

    @Test
    public void testMessageNewFactory() {
        assertEquals(MessageNewEventHandler.class, factory.getHandler(VKEventType.MESSAGE_NEW).getClass());
    }
}
