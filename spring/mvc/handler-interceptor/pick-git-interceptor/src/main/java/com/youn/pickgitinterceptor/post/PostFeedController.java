package com.youn.pickgitinterceptor.post;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.ForLoginAndGuestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostFeedController {

    @ForLoginAndGuestUser
    @GetMapping("/posts/{postId}")
    public void 포스트_상세조회() {
    }
}