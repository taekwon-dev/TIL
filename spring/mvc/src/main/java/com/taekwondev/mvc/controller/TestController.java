package com.taekwondev.mvc.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TestController {

    @GetMapping("/posts")
    public void posts() {
        System.out.println("/api/posts api called");
    }

    @ExceptionHandler(Exception.class)
    public void exceptions() {

    }
}
