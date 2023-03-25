package com.youn.index.post.application;

import com.youn.index.post.domain.PostCategory;
import com.youn.index.post.domain.repository.PostFeedRepository;
import com.youn.index.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostFeedService {

    private final PostFeedRepository postFeedRepository;

    public List<PostResponse> userFeedPagedWithOffset() {
        PostCategory category = PostCategory.of("tech");
        return postFeedRepository.fetchPostsWithOffset(category);
    }

    public List<PostResponse> userFeedPagedNoOffset() {
        PostCategory category = PostCategory.of("tech");
        return postFeedRepository.fetchPostsNoOffset(20L, category);
    }
}