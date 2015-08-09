-- DELETE FROM user_roles;
-- DELETE FROM role;
INSERT INTO role (id, rolename) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
INSERT INTO user_roles(role_id, user_id) VALUES (1, 1),(2, 1);