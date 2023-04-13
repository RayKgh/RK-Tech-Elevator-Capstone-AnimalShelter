BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,first_name, last_name, DOB, phone_number,email_address) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'test', 'test', '1995-11-11', '1231231234','test@test.com');

INSERT INTO users (username,password_hash,role, first_name, last_name, DOB, phone_number,email_address) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'test2', 'test2', '1956-12-12', '1232345432', 'test2@test2.com');

INSERT INTO pets(pet_name, breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Rocky', 'Normal Sloth', 'Black', true, 'Male', 'Available', 'Rocky is a sloth. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a

');

INSERT INTO pets(pet_name, DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Callisto','1997-10-24', 'Upside Down Sloth', 'Reddish-Brown', true, 'Female', 'Available', 'Callisto is a sloth.');

INSERT INTO pets(pet_name,DOB, breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Raisin','1996-1-1', 'Upside Down Sloth', 'Blonde', false, 'Male', 'Available', 'Raisin is a sloth.');

INSERT INTO pets(pet_name,DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Liane','2003-4-13', 'Upside Down Sloth', 'Blonde', true, 'Female', 'Adopted', 'Liane is a sloth.');

INSERT INTO pets(pet_name,DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Lightning','2003-06-12', 'Upside Down Sloth', 'Reddish-Blonde', true, 'Male', 'Adopted', 'Lightning is a sloth.');

INSERT INTO pets(pet_name,DOB,breed,color,sex,adoption_status,is_vaccinated,entry_date,pet_description)
VALUES('test name','1996-07-03','sloth','green','male','Available',true,'1997-07-03','this pet is not adopted');

INSERT INTO photos(pet_id,source,description)
VALUES(1,'https://i.imgur.com/7rhDPcZ.jpg','Rocky Photo 1');

INSERT INTO photos(pet_id,source,description)
VALUES(1,'https://i.imgur.com/674mArJ.jpg','Rocky Photo 2');

INSERT INTO photos(pet_id,source,description)
VALUES(2,'https://i.imgur.com/w2JQwor.jpg','Callisto Photo 1');

INSERT INTO photos(pet_id,source,description)
VALUES(2,'https://i.imgur.com/wyDSD1T.jpg','Callisto Photo 2');

INSERT INTO photos(pet_id,source,description)
VALUES(3,'https://i.imgur.com/D6ynbeC.jpg','Raisin Photo 1');

INSERT INTO photos(pet_id,source,description)
VALUES(3,'https://i.imgur.com/tkZ47AA.jpg','Raisin Photo 2');

INSERT INTO photos(pet_id,source,description)
VALUES(4,'https://i.imgur.com/0nZLIcu.jpg','Lianne Photo 1');

INSERT INTO photos(pet_id,source,description)
VALUES(4,'https://i.imgur.com/x9nBjf0.jpg','Lianne Photo 2');

INSERT INTO photos(pet_id,source,description)
VALUES(5,'https://i.imgur.com/ET3vUyM.jpg','Lightning Photo 1');

INSERT INTO photos(pet_id,source,description)
VALUES(5,'https://i.imgur.com/mM7JIG8.jpg','Lightning Photo 2');

INSERT INTO photos(pet_id,description)
VALUES(6,'this is a test sloth');

COMMIT TRANSACTION;
