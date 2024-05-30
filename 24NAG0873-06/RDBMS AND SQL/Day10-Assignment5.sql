USE Company;

START TRANSACTION;

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(109,4,125.00,'2024-02-19');

SAVEPOINT afterinsert1;

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(110,2,175.00,'2024-04-29');

SAVEPOINT afterinsert2;

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(111,5,1225.00,'2024-01-17');

SAVEPOINT afterinsert3;

INSERT INTO Orders(order_id,customer_id,order_value,order_date)
VALUES
(112,2,720.00,'2024-06-05');

SAVEPOINT afterinsert4;
SELECT * FROM Orders;

ROLLBACK TO afterinsert2;
SELECT * FROM Orders;

COMMIT;

