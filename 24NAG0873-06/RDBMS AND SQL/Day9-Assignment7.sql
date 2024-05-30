USE LibraryDatabase;

INSERT INTO Book(book_id,title,author,genre,publication_year,ISBN)
VALUES(1,'To kill a Mocking Bird','HArper Lee','Fiction',1960,'978');

INSERT INTO Member(member_id,name,email,phone_number,address)
VALUES(1,'Swati','swati12@gmail.com','9945678321','123 Main st'); 

INSERT INTO Checkout(checkout_id,member_id,book_id,checkout_date,due_date,returned)
VALUES(1,1,1,'2024-05-14','2024-06-14',0);

INSERT INTO Reservation(reservation_id,member_id,book_id,reservation_date,status)
VALUES(1,1,1,'2024-05-14','pending');

UPDATE Member
SET phone_number = '6301692267'
WHERE member_id = 1;

UPDATE Book
SET genre = 'Literacy Fiction'
WHERE book_id = 1;

DELETE FROM Checkout 
WHERE returned = 1;

DELETE FROM Reservation 
WHERE status = 'cancelled';

SELECT * FROM books;  -- This books table was added by BULK INSERT.
