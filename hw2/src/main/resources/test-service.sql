DROP TABLE IF EXISTS seller CASCADE;
DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE seller (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	age INTEGER
);

CREATE TABLE product (
   id INTEGER AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(256) UNIQUE,
   price INTEGER,
   created DATETIME,
   updated DATETIME,
   seller_id INTEGER,
   FOREIGN KEY(seller_id) REFERENCES seller(id)
);

INSERT INTO seller(name, age) VALUES('윤서준', 20);
INSERT INTO seller(name, age) VALUES('윤광철', 43);
INSERT INTO seller(name, age) VALUES('공미영', 23);
INSERT INTO seller(name, age) VALUES('김도윤', 30);

INSERT INTO product(name, price, created, updated, seller_id) VALUES('세탁기', 1200000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('건조기', 800000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('TV', 4000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('컴퓨터', 1500000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
