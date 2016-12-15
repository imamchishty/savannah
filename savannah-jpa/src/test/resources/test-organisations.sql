-- Organisations

INSERT INTO organisation (id, name, description) VALUES ('a', 'apple', 'apple inc.');
INSERT INTO organisation (id, name, description) VALUES ('b', 'google', 'google inc.');
INSERT INTO organisation (id, name, description) VALUES ('c', 'intel', 'intel inc.');

-- Profiles

INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa1', 'dev', 'development environment', 'a');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa2', 'test', 'test environment', 'a');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa3', 'prod', 'production environment', 'a');

INSERT INTO profile (id, name, description, organisation_id) VALUES ('bb1', 'dev', 'development environment', 'b');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('bb2', 'test', 'test environment', 'b');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('bb3', 'prod', 'production environment', 'b');

INSERT INTO profile (id, name, description, organisation_id) VALUES ('cc1', 'dev', 'development environment', 'c');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('cc2', 'test', 'test environment', 'c');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('cc3', 'prod', 'production environment', 'c');

-- Services

INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa1', 'login', 'login service', 'dubai', 'github.com/login', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa2', 'order', 'order service', 'dubai', 'github.com/order', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa3', 'account', 'account service', 'dubai', 'github.com/account', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa4', 'tracking', 'tracking service', 'dubai', 'github.com/tracking', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa5', 'setting', 'settings service', 'dubai', 'github.com/setting', 'a');

INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('bbb5', 'setting', 'settings service', 'dubai', 'github.com/setting', 'b');

INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('ccc5', 'setting', 'settings service', 'dubai', 'github.com/setting', 'c');
