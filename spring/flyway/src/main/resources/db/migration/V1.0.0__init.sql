CREATE TABLE user
(
    `id`        BIGINT         NOT NULL    AUTO_INCREMENT COMMENT '유저 ID',
    `username`  VARCHAR(50)    NOT NULL    COMMENT '유저 네임',
    `password`  VARCHAR(60)    NOT NULL    COMMENT '유저 패스워드',
    PRIMARY KEY (id)
);