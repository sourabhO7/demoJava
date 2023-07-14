# GloLogictics

**Problem statement of GloLogistics:**

GloLogistics, a prominent leader in the logistics industry and supply chain, has established an extensive network of suppliers. To efficiently manage this vast network, they initially relied on file handling systems. However, they encountered challenges with data redundancy, particularly in handling duplicate entries. Recognizing the need for a more robust solution, GloLogistics made a strategic decision to migrate their operations to a database system utilizing JDBC (Java Database Connectivity).

Here, Alex has shown the basic CRUD operation implementation to show communication between application and the database using jdbc

In the example, Alex a software engineer is performing the basic CRUD opeartion using statement object only. 

**Table creation query**

CREATE TABLE supplier (
    supId VARCHAR(10) PRIMARY KEY,
    supName VARCHAR(50),
    supType VARCHAR(50),
    supCity VARCHAR(50),
    supEmail VARCHAR(100)
);


Database name should be **glologisticsdb**

CREATE DATABASE glologistics;
