CREATE TABLE EAGER_MEMBER
(
    `id`              BIGINT          NOT NULL    AUTO_INCREMENT,
    `name`            VARCHAR(50)     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE EAGER_ORDERS
(
    `id`              BIGINT          NOT NULL    AUTO_INCREMENT,
    `name`            VARCHAR(50)     NOT NULL,
    `eager_id`        BIGINT          NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (eager_id) REFERENCES EAGER_MEMBER (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


CREATE TABLE LAZY_MEMBER
(
    `id`              BIGINT          NOT NULL    AUTO_INCREMENT,
    `name`            VARCHAR(50)     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE LAZY_ORDERS
(
    `id`              BIGINT          NOT NULL    AUTO_INCREMENT,
    `name`            VARCHAR(50)     NOT NULL,
    `lazy_id`         BIGINT          NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (lazy_id) REFERENCES LAZY_MEMBER (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
