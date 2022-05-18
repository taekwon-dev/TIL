CREATE TABLE user
(
    `id`        BIGINT         NOT NULL    AUTO_INCREMENT COMMENT '유저 ID',
    `username`  VARCHAR(50)    NOT NULL    COMMENT '유저 네임',
    `password`  VARCHAR(60)    NOT NULL    COMMENT '유저 패스워드',
    PRIMARY KEY (id)
);

CREATE TABLE post
(
    `id`       BIGINT          NOT NULL    AUTO_INCREMENT COMMENT '포스트 ID',
    `title`    VARCHAR(100)    NOT NULL    COMMENT '포스트 제목',
    `content`  LONGTEXT        NOT NULL    COMMENT '포스트 내용',
    PRIMARY KEY (id)
);

CREATE TABLE post_likes
(
    `id`       BIGINT    NOT NULL    AUTO_INCREMENT COMMENT '포스트 좋아요 ID',
    `user_id`  BIGINT    NULL        COMMENT '(좋아요 누른) 유저 ID',
    `post_id`  BIGINT    NULL        COMMENT '(좋아요 대상) 포스트 ID',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);