package com.youn.message_converter.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class ControllerV1 {

    @PostMapping("/request-body")
    public ResponseEntity<RequestDtoV1> requestBody(@RequestBody RequestDtoV1 requestDtoV1) {
        return ResponseEntity.ok(requestDtoV1);
    }
}