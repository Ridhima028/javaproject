-- Create Database
CREATE DATABASE IF NOT EXISTS employee_db;

USE employee_db;

-- Create Employees Table
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    salary DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Sample Data (Optional)
INSERT INTO employees (name, email, salary) VALUES
('John Doe', 'john.doe@example.com', 50000),
('Jane Smith', 'jane.smith@example.com', 55000),
('Robert Johnson', 'robert.johnson@example.com', 60000),
('Emily Brown', 'emily.brown@example.com', 52000);
