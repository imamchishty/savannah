-- Organisations

INSERT INTO organisation (name, description) VALUES ('apple', 'apple inc.');

-- Profiles

INSERT INTO profile (name, description) VALUES ('dev', 'development environment');
INSERT INTO profile (name, description) VALUES ('test', 'test environment');
INSERT INTO profile (name, description) VALUES ('prod', 'production environment');

-- Services

INSERT INTO service (name, description, organisation_id) VALUES ('login', 'login service', 'apple');
INSERT INTO service (name, description, organisation_id) VALUES ('order', 'order service', 'apple');
INSERT INTO service (name, description, organisation_id) VALUES ('account', 'account service', 'apple');
INSERT INTO service (name, description, organisation_id) VALUES ('tracking', 'tracking service', 'apple');
INSERT INTO service (name, description, organisation_id) VALUES ('setting', 'settings service', 'apple');

-- Instances

INSERT INTO service_instance (id, service_id, version, profile_id, url, container_image, date_time, build_number, build_job)
VALUES ('a', 'login', '1.0.3', 'dev', 'dev-url', 'container-image', '2017-01-01 10:00:00', '103', 'jenkins-url');


-- APIs

INSERT INTO service_instance_api (id, version, description, instance_id) VALUES ('a', '1.3', 'Authentication Service', 'a');

-- Dependencies

INSERT INTO service_instance_dependency (name, version, description, instance_id, type)
VALUES ('org.springframework.boot:spring-boot-starter-data-jpa', '1.4.1.RELEASE', 'internal dependency', 'a', 'LIBRARY');