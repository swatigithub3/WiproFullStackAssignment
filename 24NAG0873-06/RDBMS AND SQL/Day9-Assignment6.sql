SELECT USER,HOST FROM mysql.user;
CREATE USER 'swati'@'localhost' IDENTIFIED BY 'swati@1234';
SHOW GRANTS FOR 'swati'@'localhost';
GRANT SELECT, INSERT, UPDATE ON *.* TO 'swati'@'localhost';
REVOKE UPDATE ON *.* FROM 'swati'@'localhost';
DROP USER 'swati'@'localhost';