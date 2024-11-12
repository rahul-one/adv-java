/**
 * Author:  rahulxxl
 * Created: 13 Nov, 2024
 */

/** 
 * Use the following SQL commands to create the desired table in MySQL
 */

CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE Employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100),
    salary DECIMAL(10, 2)
);