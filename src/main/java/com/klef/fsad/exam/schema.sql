-- Create Database
CREATE DATABASE IF NOT EXISTS fsadexam;
USE fsadexam;

-- Create Hospital Table
CREATE TABLE IF NOT EXISTS hospital (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE,
    status VARCHAR(50),
    location VARCHAR(100),
    phone VARCHAR(15)
);

-- Insert Sample Data
INSERT INTO hospital (name, description, date, status, location, phone) VALUES
('Apollo Hospital', 'Multi-specialty hospital with advanced facilities', '2024-01-15', 'Active', 'Hyderabad', '040-23607777'),
('CARE Hospitals', 'Specialized cardiac care center', '2024-02-20', 'Active', 'Bangalore', '080-40222222'),
('Yashoda Hospital', 'General hospital with emergency services', '2024-03-10', 'Active', 'Pune', '020-67231234');
