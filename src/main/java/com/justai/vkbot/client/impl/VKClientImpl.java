package com.justai.vkbot.client.impl;

import com.justai.vkbot.client.VKClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class VKClientImpl implements VKClient {
    private final RestTemplate restTemplate;
    @Value("${vk.api.endpoint}")
    private String apiEndpoint;
    @Value("${vk.api.version}")
    private String apiVersion;
    @Value("${vk.access-token}")
    private String accessToken;

    @Override
    public String sendMessage(String message, String userId) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user_id", userId);
        params.add("message", message);
        return apiCall("messages.send", params);
    }

    private String apiCall(String method, MultiValueMap<String, String> params) {
        params.addIfAbsent("access_token", accessToken);
        params.addIfAbsent("v", apiVersion);
        params.addIfAbsent("random_id", String.valueOf(new Random().nextInt(10000000)));
        URI uri = UriComponentsBuilder.fromUriString(apiEndpoint + method)
                .queryParams(params)
                .build()
                .toUri();
        return restTemplate.getForObject(uri, String.class);
    }
}
