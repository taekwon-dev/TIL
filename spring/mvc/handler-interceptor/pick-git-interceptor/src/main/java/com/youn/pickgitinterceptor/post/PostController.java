package com.youn.pickgitinterceptor.post;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.ForOnlyLoginUser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    @ForOnlyLoginUser
    @DeleteMapping("/posts/{postId}")
    public void 포스트_삭제() {
    }
}