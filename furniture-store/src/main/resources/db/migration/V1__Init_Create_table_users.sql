-- V1 Init - Creation of the Users Table
CREATE TABLE "Users" (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
firstname varchar(255) NOT NULL,
lastname varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255) NOT NULL,
role varchar(255) NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP NOT NULL
)