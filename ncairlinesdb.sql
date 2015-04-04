DROP DATABASE IF EXISTS nc_airlines;
CREATE DATABASE nc_airlines;
USE nc_airlines;
CREATE TABLE User_Details (
UserID VARCHAR(20) PRIMARY KEY,
FirstName VARCHAR(50),
LastName VARCHAR(50),
EmailAddress VARCHAR(50) UNIQUE,
SSN VARCHAR(45),
Address VARCHAR(100),
Date_Of_birth varchar(50),
 Phone_Number INT,
Gender VARCHAR(10)
);

   
CREATE TABLE Login_details(
    UserID VARCHAR(20) PRIMARY KEY,
    Password VARCHAR(20),
    Security_Ques1 VARCHAR(100),
    Answer1 VARCHAR(45),
    Security_Ques2 VARCHAR(100),
    Answer2 VARCHAR(45),
    CONSTRAINT user_id_fk
    FOREIGN KEY (UserID) REFERENCES User_Details(UserID)
    );


CREATE TABLE Employees (
    Employee_Id VARCHAR(20) PRIMARY KEY,
    Password VARCHAR(20),
    First_Name VARCHAR(45),
    Last_Name VARCHAR(45),
    Email_Address VARCHAR(45),
    Employee_type int
);

 CREATE TABLE Order_Details (
    Order_ID int primary key auto_increment,
    Ticket_number INT ,
    Flight_Number_Onward VARCHAR(20),
    Flight_Number_Return VARCHAR(20),
    From_Date varchar(50),
    Return_Date varchar(50),
    UserID VARCHAR(20),
    Constraint user_id_fk_2
    FOREIGN KEY(UserID) REFERENCES User_Details(UserID)
);
 
CREATE TABLE Order_Details_has_flight_details(
    Order_ID INT, 
    Flight_Number VARCHAR(20),
    PRIMARY KEY(Flight_Number, Order_ID)
);

CREATE TABLE Flight_Details (
    Flight_Number VARCHAR(20) PRIMARY KEY,
    Source VARCHAR(100),
    Destination VARCHAR(100),
    Flight_type Varchar(20)
);
CREATE TABLE Flight_Class_Price(
    Flight_Class VARCHAR(25) PRIMARY KEY,
    Price int,
    Total_seats int
);


CREATE TABLE Flight_details_has_flight_price(
    Flight_Number VARCHAR(20), 
    Flight_Class VARCHAR(25),
    PRIMARY KEY(Flight_Number, Flight_Class)
);

alter table Order_Details_has_flight_details
add constraint 
fk_order_details_order_id foreign key(Order_ID) references Order_Details(Order_ID);

alter table Order_Details_has_flight_details
add constraint 
fk_flight_detail_flight__number foreign key(Flight_Number) references Flight_details(Flight_Number);    


alter table Flight_details_has_flight_price
add constraint 
fk_flight_details_flight_number foreign key(Flight_Number) references Flight_details(Flight_Number);

alter table Flight_details_has_flight_price
add constraint 
fk_flight_class_price__flight_class foreign key(Flight_Class) references Flight_Class_price(Flight_Class);

CREATE TABLE Flight_Timing (
    Flight_Number VARCHAR(20) PRIMARY KEY,
    Arrival TIME,
    Departure TIME,
    CONSTRAINT flight_number_fk
    FOREIGN KEY (Flight_Number) REFERENCES Flight_Details(Flight_Number)
);

