-- create table if not exists singer
-- (
--     id   bigserial primary key,
--     name varchar(128) unique not null
-- );
--
-- create table if not exists users
-- (
--     id       bigserial primary key,
--     login    varchar(128) unique not null,
--     password varchar(64) UNIQUE  not null,
--     nickname varchar(64),
--     role     varchar(64)
-- );
--
--
-- create table if not exists album
-- (
--     id        bigserial primary key,
--     title     varchar(128) not null,
--     singer_id bigint,
--     cover     bytea,
--     genre     varchar(128),
--     foreign key (singer_id) references singer (id)
-- );
--
-- create table if not exists users_rating
-- (
--     id       bigserial primary key,
--     user_id  bigint,
--     album_id bigint,
--     rate     int check (rate >= 0 and rate <= 10)
-- );
-- Вставка тестовых данных в таблицу singer
INSERT INTO singer (name) VALUES
                              ('Singer1'),
                              ('Singer2');

-- Вставка тестовых данных в таблицу users
INSERT INTO users (login, password, nickname, role)
VALUES ('user1', 'password1', 'nickname1', 'role1'),
       ('user2', 'password2', 'nickname2', 'role2');


-- Вставка тестовых данных в таблицу album
INSERT INTO album (title, singer_id, genre)
VALUES ('Album1', 1, 'Genre1'),
       ('Album2', 2, 'Genre2');

-- Вставка тестовых данных в таблицу users_rating
INSERT INTO users_rating (user_id, album_id, rate)
VALUES (1, 1, 5),
       (2, 2, 8);
