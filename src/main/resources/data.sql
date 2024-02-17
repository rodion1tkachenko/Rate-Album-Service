create table if not exists singer
(
    id   bigserial primary key,
    name varchar(128) unique not null
);

create table if not exists users
(
    id       bigserial primary key,
    login    varchar(128) unique not null,
    password varchar(64) UNIQUE  not null,
    nickname varchar(64),
    role     varchar(64)
);


create table if not exists album
(
    id        bigserial primary key,
    title     varchar(128) not null,
    singer_id bigint,
    cover     bytea,
    genre     varchar(128),
    foreign key (singer_id) references singer (id)
);

create table if not exists users_rating
(
    id       bigserial primary key,
    user_id  bigint,
    album_id bigint,
    rate     int check (rate >= 0 and rate <= 10)
);