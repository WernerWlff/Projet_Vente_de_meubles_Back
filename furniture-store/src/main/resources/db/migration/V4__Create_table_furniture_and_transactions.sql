-- V4 Create table furnitures and transactions
DROP TABLE if EXISTS "Users";

CREATE TABLE furnitures (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
title varchar(255) NOT NULL,
type_id BIGINT REFERENCES Types(id),
description TEXT NOT NULL,
price DECIMAL NOT NULL,
status_id BIGINT REFERENCES status(id),
created_at TIMESTAMP NOT NULL,
photo varchar(255) NOT NULL,
vendor_id BIGINT REFERENCES users(id)
);

CREATE TABLE transactions (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
furniture_id BIGINT REFERENCES furnitures(id),
user_id BIGINT REFERENCES users(id),
sold_at TIMESTAMP NOT NULL
);