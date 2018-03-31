CREATE TABLE Test_Persons (
    PersonId int NOT NULL PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);

CREATE TABLE Test_Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonId int,
    PRIMARY KEY (OrderID),
    CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonId)
    REFERENCES Test_Persons(PersonId)
);

CREATE SEQUENCE orders_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;