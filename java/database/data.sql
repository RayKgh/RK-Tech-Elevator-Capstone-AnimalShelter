BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,first_name, last_name, DOB, phone_number,email_address) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'test', 'test', '2011-11-11', '1231231234','test@test.com');

INSERT INTO users (username,password_hash,role, first_name, last_name, DOB, phone_number,email_address) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'test2', 'test2', '2012-12-12', '1232345432', 'test2@test2.com');


INSERT INTO pets(pet_name, breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('name1',  'test', 'test', false, 'test', 'test', 'test');

INSERT INTO pets(pet_name,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('name2', 'test', 'test', true, 'test', 'test', 'test');

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
