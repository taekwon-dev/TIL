package com.youn.index.post.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class PostResponse {

    public Long id;
    public String title;
    public String content;
    public LocalDateTime created_at;

    public PostResponse() {
    }

    @Builder
    public PostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime created_at
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }
}