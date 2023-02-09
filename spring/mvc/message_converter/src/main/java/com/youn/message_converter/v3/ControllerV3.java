package com.youn.message_converter.v3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v3")
public class ControllerV3 {

    @PostMapping("/request-body")
    public ResponseEntity<RequestDtoV3> requestBody(@RequestBody RequestDtoV3 requestDtoV3) {
        return ResponseEntity.ok(requestDtoV3);
    }
}