package com.youn.message_converter.v0;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v0")
public class ControllerV0 {

    @PostMapping("/request-body")
    public ResponseEntity<RequestDtoV0> requestBody(@RequestBody RequestDtoV0 requestDtoV0) {
        return ResponseEntity.ok(requestDtoV0);
    }
}