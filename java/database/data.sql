BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,first_name, last_name, DOB, phone_number,email_address) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Josh', 'Coffey', '1995-11-11', '1231231234','josh.coffey@cincysloths.com');

INSERT INTO users (username,password_hash,role, first_name, last_name, DOB, phone_number,email_address) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Nayilah', 'Roper', '2003-12-12', '1232345432', 'admin@cincysloths.com');

INSERT INTO pets(pet_name, breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Rocky', 'Normal Sloth', 'Black', true, 'Male', 'Available', 'Rocky is very well behaved. He always finishes his dinner, and loves to take naps.');

INSERT INTO pets(pet_name, DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Callisto','1997-10-24', 'Upside Down Sloth', 'Reddish-Brown', true, 'Female', 'Available', 'Callisto is very kind. She always shares her veggies and loves to snuggle.');

INSERT INTO pets(pet_name,DOB, breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Raisin','1996-1-1', 'Upside Down Sloth', 'Blonde', false, 'Male', 'Available', 'Raisin is as loyal as they come. He will follow you around like your own shaddow.');

INSERT INTO pets(pet_name,DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Liane','2003-4-13', 'Upside Down Sloth', 'Blonde', true, 'Female', 'Available', 'Liane is such a sweetheart. She is always down for a cuddle.');

INSERT INTO pets(pet_name,DOB,  breed, color, is_vaccinated, sex, adoption_status, pet_description)
VALUES ('Lightning','2003-06-12', 'Upside Down Sloth', 'Reddish-Blonde', true, 'Male', 'Available', 'Lightning is very playful. Lightning requires an active parent willing to keep up at his pace.');


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



INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-12', 'pending', 'Evan', 'Amezcua', '1992-10-01', '1234567890', 'evanA@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-12', 'pending', 'Carly', 'Trimboli', '1994-02-04', '2468101214', 'CoolCarly@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-13', 'pending', 'Monika', 'Royal-Fischer', '1995-10-22', '3725100987', 'MonikaRulez@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-13', 'pending', 'Robyn', 'Florentz', '1997-06-09', '0987123467', 'dontmesswithrobyn@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-14', 'pending', 'Stefan', 'Kyntchev', '1992-12-11', '9871287650', 'Stefan182@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-14', 'pending', 'David', 'Pfaltzgraff-Carlson', '1997-09-25', '1245780243', 'contactDavid@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-14', 'pending', 'Megan', 'Hunziker', '1992-01-02', '4512398736', 'Megan4ever@email.com');

INSERT INTO applications(application_date, status, first_name, last_name, DOB, phone_number, email_address)
VALUES('2023-04-15', 'pending', 'Mike', 'Levy', '1994-02-17', '0000000000', 'tecincymike@email.com');


COMMIT TRANSACTION;
