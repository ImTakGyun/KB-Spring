DROP TABLE IF EXISTS seller CASCADE;

CREATE TABLE seller (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	age INTEGER
);

INSERT INTO seller(name, age) VALUES('윤서준', 20);
INSERT INTO seller(name, age) VALUES('윤광철', 43);
INSERT INTO seller(name, age) VALUES('공미영', 23);
INSERT INTO seller(name, age) VALUES('김도윤', 30);