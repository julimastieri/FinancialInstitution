USE online_shop;

#INSERTS

INSERT INTO Users (`name`,`last_name`,`age`,`email`,`password`,`mobile`)
VALUES ('Julian','Mastieri',22,'julimastieri@gmail.com',1234,123456789);

INSERT INTO Users (`name`,`last_name`,`age`,`email`,`password`,`mobile`)
VALUES ('Valeria','Tottene',null,'vale@mail.com',1234,123456789);

INSERT INTO Users (`name`,`last_name`,`age`,`email`,`password`,`mobile`)
VALUES ('Roman','Riquelme',40,'jrr@mail.com',1234,123456789);

INSERT INTO Products (`name`,`price`,`description`,`user_id`)
VALUES('iPhone12 Pro Max',1300,'The new iPhone',1);

INSERT INTO Products(`name`,`price`,`description`,`user_id`)
VALUES('ASUS Zenbook14',1500, 'An ultrabook', 2);

INSERT INTO Products(`name`,`price`,`description`,`user_id`)
VALUES('Keyboard',100, 'With RGB', 1);

INSERT INTO Products(`name`,`price`,`description`,`user_id`)
VALUES('Samsung Galaxy Note 20 Ultra',1300, 'An ultrabook', 3);

INSERT INTO Addresses(`number`,`street`,`city`,`province`,`country`)
VALUES(824,'Roca','Tandil','Buenos Aires','Argentina');

INSERT INTO Addresses(`number`,`street`,`city`,`province`,`country`)
VALUES(1220,'9 de Julio','Capital Federal','Buenos Aires','Argentina');

INSERT INTO Orders(`total`,`discount`,`buyer_id`,`shipping_address`)
VALUES(1500,0,1,1);

INSERT INTO Orders(`total`,`discount`,`buyer_id`,`shipping_address`)
VALUES(8000,20,1,2);

INSERT INTO Orders(`total`,`discount`,`buyer_id`,`shipping_address`)
VALUES(2000,9,3,2);

INSERT INTO Orders(`total`,`discount`,`buyer_id`,`shipping_address`)
VALUES(1000,9,3,2);

#UPDATES

UPDATE Users SET `email` ='update@mail.com'
WHERE `id` = 2;

UPDATE Orders SET `discount` = 10
WHERE `id` = 3;

UPDATE Addresses SET `city` = 'Azul'
WHERE `id` = 1;

UPDATE Products SET `price` = 2000
WHERE `id` = 1;

UPDATE Products SET `description` = 'Computer'
WHERE `id` = 2;

#DELETES

DELETE FROM Users u
WHERE u.age > 21;

DELETE FROM Users u
WHERE u.age IS NULL;

DELETE FROM Products p
WHERE p.price > 1600;

DELETE FROM Addresses a
WHERE a.number<1000;

DELETE FROM Orders o
WHERE o.discount > 5;

DELETE FROM Orders o
WHERE o.discount > 5;

#BIG SELECT

SELECT *
FROM Users u INNER JOIN Products p ON u.id=p.user_id
	INNER JOIN Orders o ON o.buyer_id=u.id
    INNER JOIN Addresses a ON o.shipping_address=a.id
    INNER JOIN User_Adresses ua ON ua.user_id=u.id
WHERE u.AGE > 21;

#7 HAVINGS

SELECT u.id, u.name, count(*) AS associated_addresses
FROM Users u INNER JOIN User_Adresses ua ON ua.user_id=u.id
GROUP BY u.id
HAVING count(*)>1;

SELECT u.id, u.name, u.last_name, SUM(p.price) AS total_product_value
FROM Users u INNER JOIN Products p ON u.id=p.user_id
GROUP BY u.id
HAVING SUM(p.price)>1300;

SELECT u.id, u.name, u.last_name, AVG(p.price) AS avg_product_value
FROM Users u INNER JOIN Products p ON u.id=p.user_id
GROUP BY u.id
HAVING AVG(p.price)>(SELECT AVG(p.price) FROM Products p);

SELECT a.id, a.number, a.street, a.city, MIN(o.discount) AS min_discount
FROM Orders o INNER JOIN Addresses a ON o.shipping_address=a.id
GROUP BY a.id
HAVING MIN(o.discount)<10;

SELECT u.id, u.name, u.last_name, count(*) AS orders_quantity
FROM Users u INNER JOIN Orders o ON o.buyer_id=u.id
GROUP BY u.id
HAVING count(*) > 1;

SELECT p.price, count(*) AS products_count_price
FROM Products p
GROUP BY p.price
HAVING count(*) > 1;

SELECT u.age, count(*) AS users_count_age
FROM Users u
GROUP BY u.age
HAVING count(*) > 1;

#3 GROUP BY and the same 3 whithout GROUP BY
#1
SELECT u.id, u.name, u.last_name, count(*) AS orders_quantity
FROM Users u INNER JOIN Orders o ON o.buyer_id=u.id
GROUP BY u.id;

SELECT *
FROM Users u INNER JOIN Orders o ON o.buyer_id=u.id;

#2
SELECT u.id, u.name, count(*) AS associated_addresses
FROM Users u INNER JOIN User_Adresses ua ON ua.user_id=u.id
GROUP BY u.id;

SELECT *
FROM Users u INNER JOIN User_Adresses ua ON ua.user_id=u.id;

#3
SELECT u.id, u.name, u.last_name, SUM(p.price) AS total_product_value
FROM Users u INNER JOIN Products p ON u.id=p.user_id
GROUP BY u.id;

SELECT *
FROM Users u INNER JOIN Products p ON u.id=p.user_id;