USE Company;
CREATE TABLE Orders(
order_id INT PRIMARY KEY,
customer_id INT,
order_value DECIMAL(10,2),
order_date DATE,
FOREIGN KEY(customer_id) REFERENCES Customers (customer_id)
);

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(101,1,150.00,'2024-01-15'),
(102,1,200.00,'2024-02-20'),
(103,2,300.00,'2024-03-10'),
(104,3,50.00,'2024-04-05'),
(105,4,400.00,'2024-05-12'),
(106,5,100.00,'2024-06-18'),
(107,5,250.00,'2024-07-22');

SELECT Customers.*, Orders.*
FROM Customers
INNER JOIN Orders ON Customers.customer_id = Orders.customer_id
WHERE Customers.region = 'East';

SELECT Customers.*, Orders.*
FROM Customers
LEFT JOIN Orders ON Customers.customer_id = Orders.customer_id;
