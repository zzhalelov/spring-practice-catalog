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