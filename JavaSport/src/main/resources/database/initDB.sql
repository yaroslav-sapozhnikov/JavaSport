CREATE TABLE IF NOT EXISTS countries
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(70) NOT NULL ,
    short_name VARCHAR(5) NOT NULL
);