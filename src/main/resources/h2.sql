CREATE TABLE bdt_user (
    oid varchar(255) NOT NULL,
    id varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    age int NOT NULL,
    gender varchar (1) NOT NULL,
    primary key(oid)
);

INSERT INTO bdt_user (oid, id, name, password, age, gender) VALUES ('5XYQ15SQIOP', 'sangsang6914', '우상훈', 'asdf123412#', 30, 'M');