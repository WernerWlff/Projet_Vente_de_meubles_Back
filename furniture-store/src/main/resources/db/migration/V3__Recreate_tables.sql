-- V3 Create table furnitures
DROP TABLE if EXISTS Users;
DROP TABLE if EXISTS types;
DROP TABLE if EXISTS status;

CREATE TABLE "users" (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
firstname varchar(255) NOT NULL,
lastname varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255) NOT NULL,
role varchar(255) NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP NOT NULL
);

CREATE TABLE "types" (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
type varchar(255) NOT NULL
);

CREATE TABLE "status" (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
status varchar(255) NOT NULL
);