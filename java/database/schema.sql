BEGIN TRANSACTION;

DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS applications;


CREATE TABLE applications (
	application_id SERIAL PRIMARY KEY,
	application_date date NOT NULL,
	status varchar(20) DEFAULT 'pending',
	first_name varchar(50),
	last_name varchar(50),
	DOB varchar(50),
	phone_number varchar(10),
	email_address varchar(50)
);

CREATE TABLE users (
	user_id SERIAL,
	application_id int,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL CHECK (role IN ('ROLE_ADMIN','ROLE_USER')),
	first_name varchar(50),
	last_name varchar(50),
	DOB varchar(50),
	phone_number varchar(10),
	email_address varchar(50),
	CONSTRAINT fk_users FOREIGN KEY(application_id) REFERENCES applications(application_id)
);

CREATE TABLE pets(
	pet_id SERIAL PRIMARY KEY,
	pet_name varchar(20),
	DOB date,
	breed varchar(20),
	color varchar(20),
	sex varchar(6),
	adoption_status varchar(30) CHECK (adoption_status IN ('Available','Adopted')),
	is_vaccinated boolean,
	entry_date date,
	adoption_date date CONSTRAINT adoption_date_exists_only_if_adoption_status_is_adopted CHECK (
	((adoption_status IN ('Available','Adopted')) AND adoption_date IS NULL)
	OR
	((adoption_status='Available') AND adoption_date IS NULL)
	OR
	((adoption_status='Adopted') AND adoption_date IS NOT NULL)
	),
	pet_description varchar(500)
);

CREATE TABLE photos(
	photo_id SERIAL PRIMARY KEY,
	pet_id int NOT NULL,
	source varchar(500) NOT NULL DEFAULT 'https://i.imgur.com/gYePOeR.png',
	description varchar(100),
	
	CONSTRAINT fk_photos FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);
COMMIT TRANSACTION;
