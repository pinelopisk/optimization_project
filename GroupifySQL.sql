CREATE DATABASE IF NOT EXISTS QuestionnaireDB;
USE QuestionnaireDB;



CREATE TABLE responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    am VARCHAR(50),
    name VARCHAR(100),
    surname VARCHAR(100),
    email VARCHAR(100),
    q1 INT,
    q2 INT,
    q3 INT,
    q4 INT,
    q5 INT,
    q6 INT,
    q7 INT,
    q8 INT,
    q9 INT,
    q10 INT,
    q11 INT,
    q12 INT,
    q13 INT,
    q14 INT,
    q15 INT,
    q16 INT,
    q17 INT,
    q18 INT,
    q19 INT,
    q20 INT,
    team INT DEFAULT NULL
);
