CREATE DATABASE Company;
USE Company;

CREATE TABLE Customers(
customer_id INT PRIMARY KEY ,
customer_name VARCHAR(100) NOT NULL,
email_address VARCHAR(100) NOT NULL,
city VARCHAR(40),
region VARCHAR(40)
);

INSERT INTO Customers(customer_id,customer_name,email_address,city,region)
VALUES
(1,'Swati','swati1@gmail.com','Bhubaneswar','East'),
(2,'Sthiti','sthiti2@gmail.com','Cuttack','West'),
(3,'Mona','mona3@gmail.com','Kolkata','Midwest'),
(4,'Diya','diya4@gmail.com','Delhi','South'),
(5,'Swadhin','swadhin5@gmail.com','Mumbai','East');

SELECT * FROM Customers;

SELECT customer_name, email_address
FROM Customers
WHERE city = 'Delhi';


