CREATE DATABASE vehicle_tracker;
USE vehicle_tracker;

CREATE TABLE Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_id VARCHAR(50) NOT NULL,
    vehicle_name VARCHAR(50) NOT NULL,
    vehicle_model VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    tracking_id INT,
    FOREIGN KEY (tracking_id) REFERENCES VehicleTracking(id)
);
CREATE TABLE VehicleTracking (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tracking_system_name VARCHAR(100) NOT NULL
);