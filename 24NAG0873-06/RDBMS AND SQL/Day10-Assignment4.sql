USE Company;
CREATE TABLE Products (
product_id INT PRIMARY KEY,
product_name VARCHAR(100),
stock_quantity INT
);

INSERT INTO Products(product_id,product_name,stock_quantity)
VALUES
(150,'Sample Product 1',100),
(151,'Sample Product 2',50),
(152,'Sample Product 3',200),
(153,'Sample Product 4',140),
(154,'Sample Product 5',90);

SELECT * FROM Products;

START TRANSACTION;

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(108,3,500.00,'2024-05-03');

COMMIT;

SELECT * FROM Orders;

BEGIN;

UPDATE Products
SET stock_quantity = 30
WHERE product_id = 151;

SELECT * FROM Products;

ROLLBACK;

SELECT * FROM Products;