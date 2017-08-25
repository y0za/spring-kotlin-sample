CREATE TABLE users (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    screen_name VARCHAR(20) NOT NULL,
    display_name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE statuses (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    text VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE comments (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    status_id BIGINT NOT NULL,
    text VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL
);
