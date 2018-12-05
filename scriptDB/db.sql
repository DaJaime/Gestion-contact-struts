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
 PRIMARY KEY (TelephoneId),
  CONSTRAINT FKTelToContact FOREIGN KEY (FKTelephoneContactId) REFERENCES Contact(ContactId) ON DELETE CASCADE
 );
 
 CREATE TABLE GroupeName (
 GroupeNameId INT NOT NULL AUTO_INCREMENT,
 GroupeNom VARCHAR(255) NOT NULL,
 PRIMARY KEY (GroupeNameId));
 
 CREATE TABLE Groupe (
 GroupeId INT NOT NULL AUTO_INCREMENT,
 FKGroupeNameId INT NOT NULL,
 FKGroupeContactId INT NOT NULL,
 PRIMARY KEY (GroupeId),
 CONSTRAINT FKGroupeToGroupeName FOREIGN KEY (FKGroupeNameId) REFERENCES GroupeName(GroupeNameId) ON DELETE CASCADE,
 CONSTRAINT FKContactToContactId FOREIGN KEY (FKGroupeContactId) REFERENCES Contact(ContactId) ON DELETE CASCADE
 );


INSERT INTO GroupeName(GroupeNom) VALUES("ALL");

desc Contact;
desc Telephone;
desc Groupe;
