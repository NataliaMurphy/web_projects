DROP database if exists nbaddb;
Create database nbaddb;
use nbaddb;

CREATE TABLE PRODUCT(
productCode VARCHAR(10) primary key,
productName VARCHAR(50),
catalogCategory VARCHAR(50),
description VARCHAR(400),
imageURL varchar(50) not null,
price double(7,3)
);

CREATE TABLE USER(
userID VARCHAR(50) NOT NULL,
firstName VARCHAR(50),
lastName VARCHAR(50),
emailAddr VARCHAR(100),
address1Field VARCHAR(80),
address2Field VARCHAR(80),
city VARCHAR(50),
state VARCHAR(50),
zipPostalCode VARCHAR(50),
country VARCHAR(50),
password VARCHAR(50),
PRIMARY KEY (userID)
);

insert into product
(productCode,productName,catalogCategory,description,imageURL,price)
values
("1XX1","Casual-shirts", "Menclothing","Android(4.4.2),5.1 inches display,432 ppi, Light sensor, Proximity sensor and
Scratch-resistant glass.Quad Core processor and 32 GB in built storage.","images/Casualshirt.jpg",699.0),
("1XX2","Jeans", "Menclothing","very good quality jeans available.All sorts of brands are present here.All kinds of styles -'Regular fit','Skinny fit',
Slim fit jeans etc.","images/Jeans.jpg",1200.00),
("1XX3","sports-wear", "Menclothing","very good quality sports wear available.All sorts of brands are present here.All kinds of styles -Track pants, track suits,Track shorts, 
sports t-shirts etc.","images/Sportswear.jpg",100.00),
("1XX4","Mobiles", "Electronics","Very good quality and latest mobile phones available. All kinds of brands are present here like - Motorola , samsung , apple , blackberry ,HTC 
, Nokia , LG etc.","images/Mobile.jpg",800.0),
("1XX5","Laptops", "Electronics","Excellent quality laptops are available here. All kinds of brands are available like - Lenovo , Toshiba , LG , Compaq , Dell,Sony 
, ASUS etc","images/lenovo.jpg",860.00),
("1XX6","Televisions", "Electronics","Excellent quality televisions are available here.All sorts of brands with 3D technology are present like - ONIDA ,Sony ,Samsung , 
LG ,Sony Bravia , Croma etc","images/Television.jpg",1200.00);



insert into user
values
("Arjun","Arjun","Srinivasa","arjun.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","arjun"),
("Prashanth","Prashanth","Vardhan","prashanth.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","prashanth"),
("Madhu","Madhu","Chatra","madhu.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","madhu"),
("Sourabh","Sourabh","Bunan","sourabh.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","sourabh");


CREATE TABLE orderitem (
 `OrderNumber` int(50) NOT NULL,
 `ProductCode` Varchar(20) NOT NULL,
 `Quantity` int(11) NOT NULL,
 PRIMARY KEY (`OrderNumber`,`ProductCode`)
);
CREATE TABLE orders (
`OrderNumber` int(50) NOT NULL AUTO_INCREMENT,
 `Date` Varchar(20) NOT NULL,
 `UserID` Varchar(20) NOT NULL,
 `TaxRate` FLOAT(5,3) NOT NULL,
 `TotalCost` double(50,0) NOT NULL,
 `Paid` Boolean NOT NULL,
 PRIMARY KEY (`OrderNumber`)
);

alter table orders
AUTO_INCREMENT = 1000;

create table UserPass (
Username varchar(15) not null primary key,
password varchar(15) not null
);

insert into UserPass values
("arjun","arjun123"),
("radhika","radhika123"),
("david","david123");

create table UserRole (
Username varchar(15) not null,
Rolename varchar(15) not null,

primary key (Username,Rolename)
);

insert into UserRole values
("arjun","admin"),
("radhika","admin"),
("david","user");
