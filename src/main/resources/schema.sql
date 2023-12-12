-- TODO manually: create database should be done manually before running application
--CREATE DATABASE IF NOT EXISTS spring_quickly;

CREATE TABLE IF NOT EXISTS purchase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product varchar(100) NOT NULL,
    price double NOT NULL
);