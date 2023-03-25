CREATE TABLE user
(
    `id`        BIGINT          NOT NULL    AUTO_INCREMENT,
    `username`  VARCHAR(100)    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post_1m
(
    `id`               BIGINT          NOT NULL    AUTO_INCREMENT,
    `user_id`          BIGINT          NOT NULL,
    `category`         VARCHAR(20)     NOT NULL,
    `title`            VARCHAR(255)    NOT NULL,
    `content`          LONGTEXT        NOT NULL,
    `created_at`       TIMESTAMP       NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE post_5m
(
    `id`               BIGINT          NOT NULL    AUTO_INCREMENT,
    `user_id`          BIGINT          NOT NULL,
    `category`         VARCHAR(20)     NOT NULL,
    `title`            VARCHAR(255)    NOT NULL,
    `content`          LONGTEXT        NOT NULL,
    `created_at`       TIMESTAMP       NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);