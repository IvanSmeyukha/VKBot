package com.justai.vkbot.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VKEventType {
    CONFIRMATION("confirmation"),
    MESSAGE_NEW("message_new");

    private final String name;

    VKEventType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
