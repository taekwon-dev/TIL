package com.youn.index.post.presentation;

import com.youn.index.post.application.PostFeedService;
import com.youn.index.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostFeedService postFeedService;

    @GetMapping("/posts/paged-offset")
    public ResponseEntity<List<PostResponse>> readPostsPagedWithOffset() {
        List<PostResponse> postResponses = postFeedService.userFeedPagedWithOffset();
        return ResponseEntity.ok(postResponses);
    }

    @GetMapping("/posts/paged-no-offset")
    public ResponseEntity<List<PostResponse>> readPostsPagedWithNoOffset() {
        List<PostResponse> postResponses = postFeedService.userFeedPagedNoOffset();
        return ResponseEntity.ok(postResponses);
    }
}