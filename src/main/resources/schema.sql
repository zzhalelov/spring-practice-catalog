CREATE TABLE categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE products
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR,
    price       INT,
    category_id INT REFERENCES categories (id)
);

CREATE TABLE options
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR,
    category_id INT REFERENCES categories (id)
);

CREATE TABLE values
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR,
    product_id INT REFERENCES products (id),
    option_id  INT REFERENCES options (id)
);

--Создание таблицы пользователей
CREATE TABLE users
(
    id       SERIAL primary key,
    name     VARCHAR(255),
    lastname VARCHAR(255),
    login    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role     INT,
    created  TIMESTAMP
);

--добавить к продукту ссылку на url картинки
ALTER TABLE products
    ADD COLUMN image_url VARCHAR(255);

DROP TABLE users;