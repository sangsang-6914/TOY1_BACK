DROP TABLE bdt_user IF EXISTS;

CREATE TABLE bdt_user (
    oid varchar(255) NOT NULL,
    user_id varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    age int NOT NULL,
    gender varchar (1) NOT NULL,
    primary key(oid)
);