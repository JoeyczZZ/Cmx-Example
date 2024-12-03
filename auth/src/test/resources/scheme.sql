CREATE TABLE auth_user
(
    id         VARCHAR(32)  NOT NULL PRIMARY KEY,
    account    VARCHAR(32)  NOT NULL,
    password   VARCHAR(128) NOT NULL,
    deleted    BOOLEAN      NOT NULL DEFAULT FALSE, -- 替换 tinyint(1) 为 BOOLEAN
    created_at TIMESTAMP    NOT NULL,               -- 替换 datetime 为 TIMESTAMP
    updated_at TIMESTAMP    NOT NULL,
    updated_by VARCHAR(32)  NOT NULL
);
