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
    id            BIGSERIAL PRIMARY KEY,
    login         VARCHAR NOT NULL UNIQUE,
    password      VARCHAR NOT NULL,
    name          VARCHAR,
    lastname      VARCHAR,
    role          int,
    registered_at timestamp
);

CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    user_id          BIGINT REFERENCES users (id) NOT NULL,
    status           INT,
    delivery_address VARCHAR                      NOT NULL,
    date_of_order    TIMESTAMP
);

CREATE TABLE reviews
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT REFERENCES users (id)    NOT NULL,
    product_id    BIGINT REFERENCES products (id) NOT NULL,
    review_rating SMALLINT                        NOT NULL,
    review_text   TEXT,
    review_data   TIMESTAMP
);

CREATE TABLE orders_products
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT REFERENCES orders (id),
    product_id BIGINT REFERENCES products (id),
    quantity   INT NOT NULL
);

--добавить к продукту ссылку на url картинки
ALTER TABLE products
    ADD COLUMN image_url VARCHAR(255);