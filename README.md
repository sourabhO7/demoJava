# GloLogictics
**Problem statement**

Alex want to implement the FilterRowSet in the Glologistics application to filter and get the subset of data from the complete dataset.

**Database Properties**

CREATE DATABASE glologistics;

USE glologistics;

**Create the supplier table**

CREATE TABLE supplier (
    supId VARCHAR(10) PRIMARY KEY,
    supName VARCHAR(255),
    supType VARCHAR(50),
    supCity VARCHAR(100),
    supEmail VARCHAR(255)
);

**Create the products table**

CREATE TABLE products (
    productId INT PRIMARY KEY,
    productName VARCHAR(255),
    price DECIMAL(10, 2),
    supplierId VARCHAR(10),
    FOREIGN KEY (supplierId) REFERENCES supplier(supId)
);

**Insert sample data into the supplier table**

INSERT INTO supplier (supId, supName, supType, supCity, supEmail)
VALUES
    ('S1001', 'ABC Suppliers', 'Manufacturer', 'London', 'abc@example.com'),
    ('S1002', 'XYZ Suppliers', 'Distributor', 'New York', 'xyz@example.com'),
    ('S1003', 'PQR Suppliers', 'Wholesaler', 'Paris', 'pqr@example.com');

**Insert sample data into the products table**

INSERT INTO products (productId, productName, price, supplierId)
VALUES
    (1, 'Laptop', 999.99, 'S1001'),
    (2, 'Smartphone', 599.99, 'S1002'),
    (3, 'Headphones', 99.99, 'S1001'),
    (4, 'Camera', 799.99, 'S1003'),
    (5, 'Smart TV', 1499.99, 'S1002');

Create these two tables in the database then execute the code to see the function of the Filtered Rowset.
