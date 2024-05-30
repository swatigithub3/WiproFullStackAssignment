USE Company;
SELECT customer_id,customer_name
FROM Customers
WHERE customer_id IN (
SELECT customer_id
FROM Orders
GROUP BY customer_id
HAVING AVG(order_value) > (SELECT AVG(order_value) FROM Orders));

SELECT customer_name,email_address
FROM Customers
WHERE city = 'Bhubaneswar'
UNION
SELECT customer_name,email_address
FROM Customers
WHERE city = 'Mumbai';