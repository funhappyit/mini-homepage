CREATE TABLE guestbook
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname      VARCHAR(30)  NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    content       VARCHAR(500) NOT NULL,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
