START TRANSACTION;

DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS procedure_price;
DROP TABLE IF EXISTS visit;
DROP TABLE IF EXISTS procedure;
DROP TABLE IF EXISTS pet; 
DROP TABLE IF EXISTS owner;

CREATE TABLE owner
(
ownerId serial,
firstName varchar(64) NOT NULL,
lastName varchar(64) NOT NULL,
address varchar(256) NOT NULL,

CONSTRAINT pk_owner PRIMARY KEY (ownerId)
);

CREATE TABLE pet
(
petId serial,
petName varchar(64) NOT NULL,
ownerId int NOT NULL,
petType varchar(64) NOT NULL,
petAge int NOT NULL,

CONSTRAINT pk_pet PRIMARY KEY (petId),
CONSTRAINT fk_pet_owner FOREIGN KEY (ownerId) REFERENCES owner(ownerId)
);

CREATE TABLE procedure
(
procedureId serial,
name varchar(64) NOT NULL,

CONSTRAINT pk_procedure PRIMARY KEY (procedureId)
);


CREATE TABLE visit
(
visitId serial,
petId int NOT NULL,
procedureId int NOT NULL,
visitDate date NOT NULL,

CONSTRAINT pk_visit PRIMARY KEY (visitId),
CONSTRAINT fk_visit_pet FOREIGN KEY (petId) REFERENCES pet(petId),
CONSTRAINT fk_visit_procedure FOREIGN KEY (procedureId) REFERENCES procedure(procedureId)
);

CREATE TABLE procedure_price
(
procPriceId serial,
procedureId int NOT NULL,
petId int NOT NULL,
price numeric(2) NOT NULL,

CONSTRAINT pk_procedure_price PRIMARY KEY (procPriceId),
CONSTRAINT fk_procedure_price_procedure FOREIGN KEY (procedureId) REFERENCES procedure(procedureId),
CONSTRAINT fk_procedure_price_pet FOREIGN KEY (petId) REFERENCES pet(petId)
);

CREATE TABLE invoice
(
invoiceId serial,
invoiceDate date NOT NULL,
petId int NOT NULL,
ownerId int NOT NULL,

CONSTRAINT pk_invoice PRIMARY KEY (invoiceId),
CONSTRAINT fk_invoice_pet FOREIGN KEY (petId) REFERENCES pet(petId),
CONSTRAINT fk_invoice_owner FOREIGN KEY (ownerId) REFERENCES owner(ownerId)
);


