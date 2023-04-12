BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO pets(pet_name, DOB, breed, color, sex, adoption_status, is_vaccinated, entry_date, adoption_date, pet_description)
VALUES ('name1', '2011-11-11', 'test','test','test','Adopted',false,'2011-11-11','2011-11-11','test');

INSERT INTO pets(pet_name, DOB, breed, color, sex, adoption_status, is_vaccinated, entry_date, adoption_date, pet_description)
VALUES ('name2','2011-11-11', 'test','test','test','Adopted',false,'2011-11-11','2011-11-11','test');

INSERT INTO photos(pet_id,source,description)
VALUES(1,'test1','test description');

INSERT INTO photos(pet_id,source,description)
VALUES(1,'test2','test description');

INSERT INTO photos(pet_id,source,description)
VALUES(1,'test3','test description');

INSERT INTO photos(pet_id,source,description)
VALUES(2,'test4','test description');

INSERT INTO photos(pet_id,source,description)
VALUES(2,'test5','test description');

INSERT INTO photos(pet_id,source,description)
VALUES(2,'test6','test description');

COMMIT TRANSACTION;
