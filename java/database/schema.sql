BEGIN TRANSACTION;

DROP TABLE IF EXISTS photo;
DROP TABLE IF EXISTS pets;

DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar(50),
	last_name varchar(50),
	DOB date,
	phone_number varchar(10),
	email_address varchar(50),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE application (
	application_id SERIAL PRIMARY KEY,
	user_id int NOT NULL,
	application_date date NOT NULL,
	status varchar(20),
	
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE pets(
	pet_id SERIAL PRIMARY KEY,
	pet_name varchar(20) NOT NULL,
	DOB date,
	breed varchar(20) NOT NULL,
	color varchar(20) NOT NULL,
	sex varchar(6) NOT NULL,
	adoption_status varchar(30) NOT NULL,
	is_vaccinated boolean DEFAULT false NOT NULL,
	entry_date date DEFAULT NOW(),
	adoption_date date DEFAULT NULL,
	pet_description varchar(500) NOT NULL
);

CREATE TABLE photo(
	photo_id SERIAL PRIMARY KEY,
	pet_id int NOT NULL,
	source varchar(500) NOT NULL,
	
	CONSTRAINT fk_photo FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);
COMMIT TRANSACTION;
