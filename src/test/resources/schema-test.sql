CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
    );
