create database atmsimulator;

show databases;
use atmsimulator;
show tables;

CREATE TABLE signup (
    form_number VARCHAR(20),
    user_name VARCHAR(20),
    father_name VARCHAR(20),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(30),
    marital_status VARCHAR(20),
    address VARCHAR(50),
    city VARCHAR(20),
    state VARCHAR(20),
    pin VARCHAR(20)
);

select * from signup;
delete from signup;

CREATE TABLE signuptwo (
    formNumber VARCHAR(20),
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(30),
    education VARCHAR(20),
    occupation VARCHAR(20),
    seniorCitizen VARCHAR(20),
    existingAccount VARCHAR(20),
    pan VARCHAR(15),
    aadhar VARCHAR(15)
); 

select * from signuptwo;
delete from signuptwo;

CREATE TABLE signupthree (
    formNumber VARCHAR(5),
    accountType VARCHAR(50),
    cardNumber VARCHAR(20),
    pinNumber VARCHAR(5),
    servicesSelected VARCHAR(150)
); 

select * from signupthree;
delete from signupthree;

CREATE TABLE login (
    formNumber VARCHAR(5),
    cardnumber VARCHAR(20),
    pinNumber VARCHAR(5)
); 

select * from login;
delete from login;

CREATE TABLE bank (
    pin VARCHAR(4),
    depositDateTime datetime,
    transactionType VARCHAR(20),
    amount VARCHAR(5)
);

select * from bank;
