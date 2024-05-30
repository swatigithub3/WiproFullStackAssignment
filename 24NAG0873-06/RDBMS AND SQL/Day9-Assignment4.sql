CREATE DATABASE LibraryDatabase;
USE LibraryDatabase;
CREATE TABLE Book(
book_id INT PRIMARY KEY,
title VARCHAR(200) NOT NULL,
author VARCHAR(200) NOT NULL,
genre VARCHAR(50),
publication_year INT,
ISBN VARCHAR(13) UNIQUE
);

CREATE TABLE Member (
member_id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(200),
phone_number VARCHAR(20) UNIQUE,
address VARCHAR(200)
);

CREATE TABLE Checkout(
checkout_id INT PRIMARY KEY,
member_id INT,
book_id INT,
checkout_date DATE,
due_date DATE,
returned BOOLEAN CHECK(returned IN (0,1)),
FOREIGN KEY (member_id) REFERENCES Member(member_id),
FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

CREATE TABLE Reservation(
reservation_id INT PRIMARY KEY,
member_id INT,
book_id INT,
reservation_date DATE,
status ENUM('pending','fulfilled','cancelled'),
FOREIGN KEY (member_id) REFERENCES Member(member_id),
FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

ALTER TABLE Member 
MODIFY COLUMN email VARCHAR (200) NOT NULL;

DROP TABLE IF EXISTS OldTable;