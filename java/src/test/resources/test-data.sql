BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO pets(name,  breed, color, is_vaccinated, sex, status,  description)
VALUES ('name1',  'test', 'test', false, 'test', 'test', 'test');

INSERT INTO pets(name,  breed, color, is_vaccinated, sex, status, description)
VALUES ('name2', 'test', 'test', true, 'test', 'test', 'test');

COMMIT TRANSACTION;
