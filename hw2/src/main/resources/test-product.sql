DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE product (
   id INTEGER AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(256),
   price INTEGER,
   created DATETIME,
   updated DATETIME,
   seller_id INTEGER,
   FOREIGN KEY(seller_id) REFERENCES seller(id)
);

INSERT INTO product(name, price, created, updated, seller_id) VALUES('세탁기', 1200000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('건조기', 800000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('TV', 4000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
INSERT INTO product(name, price, created, updated, seller_id) VALUES('컴퓨터', 1500000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
