CREATE TABLE visit_counter
(
    visit_date DATE PRIMARY KEY,
    count      BIGINT NOT NULL DEFAULT 0
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
