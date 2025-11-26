-- V8 Add sample furnitures for each type, all with status "Validé"

INSERT INTO furnitures (title, type_id, description, price, status_id, created_at, photo, vendor_id)
VALUES
('Frigo blanc', (SELECT id FROM types WHERE type = 'Frigo'), 'Frigo blanc standard', 299.99,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Table en bois', (SELECT id FROM types WHERE type = 'Table'), 'Table en bois massif pour salle à manger', 199.99,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Chaise de bureau', (SELECT id FROM types WHERE type = 'Chaise'), 'Chaise de bureau ergonomique', 89.99,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Tapis moderne', (SELECT id FROM types WHERE type = 'Tapis'), 'Tapis moderne pour salon', 59.90,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Bureau d''angle', (SELECT id FROM types WHERE type = 'Bureautique'), 'Grand bureau d''angle pour ordinateur', 249.00,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Buffet en chêne', (SELECT id FROM types WHERE type = 'Meubles'), 'Buffet en chêne avec rangements', 349.00,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Télévision 4K', (SELECT id FROM types WHERE type = 'Télévision'), 'Télévision 4K 55 pouces', 599.00,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Armoire 3 portes', (SELECT id FROM types WHERE type = 'Armoire'), 'Armoire spacieuse 3 portes', 279.00,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Lot de décorations murales', (SELECT id FROM types WHERE type = 'Décoration'), 'Ensemble de décorations murales modernes', 39.99,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Poster vintage', (SELECT id FROM types WHERE type = 'Posters'), 'Poster vintage pour chambre ou salon', 14.99,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com')),

('Tourne-disque + vinyles', (SELECT id FROM types WHERE type = 'Vynils'), 'Tourne-disque avec sélection de vinyles', 129.00,
 (SELECT id FROM status WHERE status = 'Validé'),
 CURRENT_TIMESTAMP, '',
 (SELECT id FROM users WHERE email = 'admin@furniture.com'));



