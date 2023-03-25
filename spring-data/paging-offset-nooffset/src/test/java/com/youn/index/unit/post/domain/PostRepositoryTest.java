package com.youn.index.unit.post.domain;

import com.youn.index.post.application.PostFeedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostFeedService postFeedService;

    @Test
    void test() {
        postFeedService.userFeedPagedWithOffset();
        postFeedService.userFeedPagedNoOffset();
    }
}
