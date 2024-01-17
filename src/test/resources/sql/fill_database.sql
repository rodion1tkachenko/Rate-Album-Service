INSERT INTO singer (id, name)
VALUES (1, 'Singer1'),
       (2, 'Singer2');
SELECT SETVAL('singer_id_seq', (SELECT MAX(id) FROM singer));

INSERT INTO users (id, login, password, nickname, role)
VALUES (1, 'user1', 'password1', 'nickname1', 'USER'),
       (2, 'user2', 'password2', 'nickname2', 'ADMIN');
SELECT SETVAL('users_id_seq', (SELECT MAX(id) FROM users));

INSERT INTO album (id, title, singer_id, genre)
VALUES (1, 'Album1', (select id from singer where name='Singer1'), 'Genre1'),
       (2, 'Album2', (select id from singer where name='Singer1'), 'Genre2');
SELECT SETVAL('album_id_seq', (SELECT MAX(id) FROM album));

INSERT INTO users_rating (id, user_id, album_id, rate)
VALUES (1, (select id from users where nickname='nickname1'), (select id from album where title='title1'), 5),
       (2, (select id from users where nickname='nickname2'),  (select id from album where title='title2'), 8);
SELECT SETVAL('users_rating_id_seq', (SELECT MAX(id) FROM users_rating));