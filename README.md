# GloLogictics

**Problem statement of GloLogistics:**

GloLogistics, a prominent leader in the logistics industry and supply chain, has established an extensive network of suppliers. To efficiently manage this vast network, they initially relied on file handling systems. However, they encountered challenges with data redundancy, particularly in handling duplicate entries. Recognizing the need for a more robust solution, GloLogistics made a strategic decision to migrate their operations to a database system utilizing JDBC (Java Database Connectivity).

**Solution of the problem statement:**

By transitioning to a database, GloLogistics aims to mitigate the issues of duplicate entries through the implementation of robust data constraints. Leveraging the power of JDBC, they can enforce these constraints effectively. This shift not only enhances data integrity but also streamlines their supplier management processes, ensuring smooth operations and improved efficiency.

With the adoption of a database-driven approach, GloLogistics is poised to optimize their logistics and supply chain operations, minimizing errors, and achieving greater control over their supplier network. The use of JDBC serves as a pivotal tool in this transformation, facilitating seamless communication between their application and the database, and ultimately fostering a more professional and reliable logistics ecosystem.


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
