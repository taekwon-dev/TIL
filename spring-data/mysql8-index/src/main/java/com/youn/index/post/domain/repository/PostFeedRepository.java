package com.youn.index.post.domain.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.youn.index.post.domain.PostCategory;
import com.youn.index.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.youn.index.post.domain.QPost.post;


@RequiredArgsConstructor
@Repository
public class PostFeedRepository {

    private final JPAQueryFactory queryFactory;

    public List<PostResponse> fetchPostsWithOffset(PostCategory category) {
        return queryFactory
                .select(Projections.fields(PostResponse.class,
                        post.id,
                        post.title,
                        post.content,
                        post.createdAt))
                .from(post)
                .where(post.category.eq(category))
                .orderBy(post.createdAt.desc())
                .limit(20)
                .offset(5)
                .fetch();
    }

    public List<PostResponse> fetchPostsNoOffset(Long postId, PostCategory category) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (postId != null) {
            booleanBuilder.and(post.id.lt(postId));
        }
        return queryFactory
                .select(Projections.fields(PostResponse.class,
                        post.id,
                        post.title,
                        post.content,
                        post.createdAt))
                .from(post)
                .where(
                        booleanExpression(postId),
                        post.category.eq(category)
                )
                .orderBy(post.createdAt.desc())
                .limit(20)
                .fetch();
    }

    private BooleanExpression booleanExpression(Long postId) {
        if (postId == null) {
            return null;
        }
        return post.id.lt(postId);
    }
}