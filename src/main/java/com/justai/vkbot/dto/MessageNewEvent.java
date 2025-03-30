package com.justai.vkbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageNewEvent implements CallbackEvent {
    @JsonProperty("client_info")
    private ClientInfoDto clientInfo;

    @JsonProperty("message")
    private MessageDto message;
}
