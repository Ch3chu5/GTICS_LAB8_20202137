CREATE DATABASE  IF NOT EXISTS `student` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `student`;

CREATE TABLE IF NOT exists student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gpa DECIMAL(3, 2) NOT NULL CHECK (gpa >= 0.0 AND gpa <= 4.0),
    faculty VARCHAR(50) NOT NULL,
    completed_credits INT NOT NULL,
    rankin INT NOT NULL
);
