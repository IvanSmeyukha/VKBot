package com.justai.vkbot.client;

/**
 * Client for sending requests to VK api
 */
public interface VKClient {
    /**
     * Sends a message to user's VK chat
     *
     * @param message message to sand
     * @param userId VK user id
     * @return api call response
     */
    String sendMessage(String message, String userId);
}
