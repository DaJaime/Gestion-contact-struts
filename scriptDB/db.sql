DROP DATABASE IF EXISTS jee;
CREATE DATABASE jee;
use jee;

CREATE TABLE Contact (
 ContactId INT NOT NULL AUTO_INCREMENT,
 ContactNom VARCHAR(255) NOT NULL,
 ContactPrenom VARCHAR(255) NOT NULL,
 ContactAdresse VARCHAR(255),
 ContactMail VARCHAR(255),
 ContactAutre VARCHAR(255),
 PRIMARY KEY (ContactId));

CREATE TABLE Telephone (
 TelephoneId INT NOT NULL AUTO_INCREMENT,
 TelephoneNumero INT(10) NOT NULL,
 FKTelephoneContactId INT NOT NULL,
 DescriptionNumero VARCHAR(255),
 PRIMARY KEY (TelephoneId));

CREATE TABLE Groupe (
 GroupeId INT NOT NULL AUTO_INCREMENT,
 GroupeNom INT(10) NOT NULL,
 FKGroupeContactId INT NOT NULL,
 PRIMARY KEY (GroupeId));

ALTER TABLE Telephone
ADD FOREIGN KEY (FKTelephoneContactId) REFERENCES Contact(ContactId);

ALTER TABLE Groupe
ADD FOREIGN KEY (FKGroupeContactId) REFERENCES Contact(ContactId);

desc Contact;
desc Telephone;
desc Groupe;
