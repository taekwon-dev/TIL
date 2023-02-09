package com.youn.message_converter.v2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2")
public class ControllerV2 {

    @PostMapping("/request-body")
    public ResponseEntity<RequestDtoV2> requestBody(@RequestBody RequestDtoV2 requestDtoV2) {
        return ResponseEntity.ok(requestDtoV2);
    }
}