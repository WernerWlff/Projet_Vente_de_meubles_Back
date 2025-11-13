-- V6 Change the table User to separate the roles given into a new table

CREATE TABLE "roles" (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
role VARCHAR(50) NOT NULL
);

ALTER TABLE "users" ADD COLUMN IF NOT EXISTS "role_id" BIGINT;

ALTER TABLE "users" DROP COLUMN IF EXISTS "role";

ALTER TABLE "users" ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES "roles"(id);