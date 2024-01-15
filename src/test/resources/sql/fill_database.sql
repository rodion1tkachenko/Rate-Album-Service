-- Вставка тестовых данных в таблицу singer
-- INSERT INTO singer (name) VALUES
--                               ('Singer1'),
--                               ('Singer2');

-- Вставка тестовых данных в таблицу users
INSERT INTO users (login, password, nickname, role) VALUES
                                                        ('user1', 'password1', 'nickname1', 'role1'),
                                                        ('user2', 'password2', 'nickname2', 'role2');

-- Вставка тестовых данных в таблицу album
INSERT INTO album (title, singer_id, genre) VALUES
                                                       ('Album1', 1, 'Genre1'),
                                                       ('Album2', 2, 'Genre2');

-- Вставка тестовых данных в таблицу users_rating
INSERT INTO users_rating (user_id, album_id, rate) VALUES
                                                       (1, 1, 5),
                                                       (2, 2, 8);
