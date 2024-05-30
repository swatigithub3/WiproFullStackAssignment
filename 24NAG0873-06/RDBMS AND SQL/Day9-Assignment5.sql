CREATE DATABASE Department;
USE Department;

CREATE TABLE Students(
student_id INT PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
age INT
);

INSERT INTO Students(student_id,first_name,last_name,age) VALUES
(1,'Swati','Mohanty',20),
(2,'Swadhin','Behera',21),
(3,'Mona','Sahoo',21),
(4,'Sibu','Mallik',23),
(5,'Sthiti','Mohanty',22);

CREATE INDEX age_index ON Students(age);

SELECT * FROM Students WHERE age>20;

DROP INDEX age_index ON Students;

SELECT * FROM Students WHERE age>20;