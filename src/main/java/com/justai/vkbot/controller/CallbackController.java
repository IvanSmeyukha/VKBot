package com.justai.vkbot.controller;

import com.justai.vkbot.dto.CallbackDto;
import com.justai.vkbot.service.CallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api")
@RequiredArgsConstructor
public class CallbackController {
    private final CallbackService callbackService;

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback(@RequestBody CallbackDto request) {
        return ResponseEntity.ok(callbackService.handleCallback(request));
    }
}
