package com.justai.vkbot.dto;

import com.fasterxml.jackson.annotation.*;
import com.justai.vkbot.enums.VKEventType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackDto {
    @JsonProperty("type")
    private VKEventType type;

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("object")
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type",
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = MessageNewEvent.class, name = "message_new"),
            @JsonSubTypes.Type(value = ConfirmationEvent.class, name = "confirmation")
    })
    private CallbackEvent object;
}
