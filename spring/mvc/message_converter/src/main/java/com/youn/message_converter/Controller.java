package com.youn.message_converter;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/request-body")
    public ResponseEntity<RequestDto> requestBody(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(requestDto);
    }

    @PostMapping("/request-body2")
    public ResponseEntity<HttpEntity<RequestDto>> requestBody2(HttpEntity<RequestDto> httpEntity) {
        return ResponseEntity.ok(httpEntity);
    }
}