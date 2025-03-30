package com.justai.vkbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageNewEvent implements CallbackEvent {
    @JsonProperty("client_info")
    private ClientInfoDto clientInfo;

    @JsonProperty("message")
    private MessageDto message;
}
