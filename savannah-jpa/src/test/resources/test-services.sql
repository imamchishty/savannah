-- Organisations

INSERT INTO organisation (id, name, description) VALUES ('a', 'apple', 'apple inc.');

-- Profiles

INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa1', 'dev', 'development environment', 'a');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa2', 'test', 'test environment', 'a');
INSERT INTO profile (id, name, description, organisation_id) VALUES ('aa3', 'prod', 'production environment', 'a');

-- Services

INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa1', 'login', 'login service', 'dubai', 'github.com/login', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa2', 'order', 'order service', 'dubai', 'github.com/order', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa3', 'account', 'account service', 'dubai', 'github.com/account', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa4', 'tracking', 'tracking service', 'dubai', 'github.com/tracking', 'a');
INSERT INTO service (id, name, description, team, scm, organisation_id) VALUES ('aaa5', 'setting', 'settings service', 'dubai', 'github.com/setting', 'a');

-- Instances
--INSERT INTO service_instance (id, name, service_id, scm_revision, container_image, version, status, executor, host, port, profile_id, date_time) VALUES ('aaaa1', 'login-dev', 'aaa1', 'a43fed', 'dockerhub.com/login:1.2', '1.1.0', 'STARTED', 'Jenkins', 'login-dev.server.com', 8080, 'aa1', CURRENT_TIMESTAMP());