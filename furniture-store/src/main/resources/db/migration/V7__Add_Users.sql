-- V7 Add Users and Roles

-- Insert roles
INSERT INTO "roles" ("role") VALUES
('ADMIN'),
('USER');

-- Insert Admin user
-- Password: admin123
INSERT INTO "users" ("firstname", "lastname", "email", "password", "role_id", "created_at", "updated_at") VALUES
('Admin', 'System', 'admin@furniture.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcg7b3XeKeUxWdeS86E36P4/TVm', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert regular users
-- Password: password123
INSERT INTO "users" ("firstname", "lastname", "email", "password", "role_id", "created_at", "updated_at") VALUES
('Jean', 'Dupont', 'jean.dupont@email.com', '$2a$10$2s8KKlO8oJJjNr9r3J3vNuOLEXiD.m3PnPFNqR8a2RXfBXrYx.5kK', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Marie', 'Martin', 'marie.martin@email.com', '$2a$10$2s8KKlO8oJJjNr9r3J3vNuOLEXiD.m3PnPFNqR8a2RXfBXrYx.5kK', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Pierre', 'Durand', 'pierre.durand@email.com', '$2a$10$2s8KKlO8oJJjNr9r3J3vNuOLEXiD.m3PnPFNqR8a2RXfBXrYx.5kK', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

