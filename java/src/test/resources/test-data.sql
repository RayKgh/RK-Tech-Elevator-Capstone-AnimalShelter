BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO pets(name, DOB, breed, color, is_vaccinated, sex, status, entry_date, adoption_date, description)
VALUES ('name1', '1111-11-11', 'test', 'test', 'test', 'test', false, '1111-11-11', '1111-11-11', 'test');

INSERT INTO pets(name, DOB, breed, color, sex, status, is_vaccinated, entry_date, adoption_date, description)
VALUES ('name2', '1111-11-11', 'test', 'test', 'test', 'test', true, '1111-11-11', '1111-11-11', 'test');

COMMIT TRANSACTION;
