DROP DATABASE IF EXISTS SSDI_49erZone;

CREATE DATABASE SSDI_49erZone;

USE SSDI_49erZone;


CREATE TABLE User (
	UserID Varchar(20) PRIMARY KEY,
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	EmailAddress VARCHAR(50) UNIQUE,
	Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Country VARCHAR(50),
    ZIP Varchar(20),
    DateOfBirth VARCHAR(20),
    PhoneNum VARCHAR(20),
    Course VARCHAR(50),
    Department VARCHAR(50),
    Club VARCHAR(50),
    Gender CHAR,
    UserType INT,
    userpassword VARCHAR(20),
    Ques1 VARCHAR(100),
    Ans1 VARCHAR(50),
    Ques2 VARCHAR(100),
    Ans2  VARCHAR(50)
    );
    
    
    
    CREATE TABLE Item (
	ItemID INT PRIMARY KEY,
	ItemName VARCHAR(50) UNIQUE,
	ItemDescription VARCHAR(100),
	CatalogName VARCHAR(50),
    CatalogDescription VARCHAR(100),
	ItemPrice DOUBLE,
    ImageURL VARCHAR(50)
    );
    
	
    
    CREATE TABLE News (
	NewsID INT PRIMARY KEY,
	NewsTitle VARCHAR(50) UNIQUE,
	Description VARCHAR(200)
	);
    
    CREATE TABLE EventDB (
	EventID INT PRIMARY KEY,
	EventTitle VARCHAR(50) UNIQUE,
	Description VARCHAR(200),
	TicketPrice DOUBLE
	);
    
    CREATE TABLE Job (
	JobID VARCHAR(20) PRIMARY KEY,
	JobTitle VARCHAR(50) UNIQUE,
	Description VARCHAR(2000),
    ShortDescription VARCHAR(2000),
	ApplicationID INT UNIQUE,
    ApplicationStatus VARCHAR(20),
    ApplicationDate DATE,
    JobResume VARCHAR(200)
    );
    
    CREATE  TABLE `SSDI_49erZone`.`Applications` (
  `Number` INT NOT NULL ,
  `JobID` VARCHAR(10) NULL ,
  `Name` VARCHAR(45) NULL ,
  `UserID` VARCHAR(45) NULL ,
  `Resume` VARCHAR(2000) NULL ,
  `Status` VARCHAR(45) NULL ,
  PRIMARY KEY (`Number`) );
    
    CREATE TABLE Book (
    	ISBN INT PRIMARY KEY,
    	BookTitle VARCHAR(50) UNIQUE,
    	Author VARCHAR(50),
    	BookSubject VARCHAR(50),
      Year varchar(50),
      ImageURL VARCHAR(100),
       Availability int(10),
       links varchar(200),
       links2 varchar(200),
       price varchar(200)
        );
        
    insert into book
    values
    (10002,"Basic Physics","Karl F. Kuhn","physics",1996,"images/basicphy.jpg",9
    ,"http://www.amazon.com/Basic-Physics-Self-Teaching-Karl-Kuhn/dp/0471134473/",
    "http://www.abebooks.com/servlet/SearchResults?kn=physics+by++Karl+F.+Kuhn&sts=t&x=0&y=0",
    "$13.53(amazon.com) , $4.10 (abebooks.com)"),
    (10010,"mysql","murach","Applied Databases",2013,"images/mysqlimg.jpg",10
    ,"http://www.amazon.com/Murachs-MySQL-Joel-Murach/dp/1890774685/",
    "http://www.abebooks.com/servlet/SearchResults?kn=murach%27s+mysql&sts=t",
    "$38.41(amazon.com) , $11.93 (abebooks.com)"),
    (10011,"Java Programming","murach","Java Development",2011,"images/jspimg.jpg",12
    ,"http://www.amazon.com/Murachs-Java-Programming-Joel-Murach/dp/1890774650/",
    "http://www.abebooks.com/servlet/SearchResults?kn=java+programming+murach&sts=t&x=0&y=0",
    "$38.62(amazon.com) , $13.12(abebooks.com)");

INSERT INTO `SSDI_49erZone`.`Applications` (`Number`, `JobID`, `Name`, `UserID`, `Resume`) VALUES ('1', 'STU070', 'Maxa Million', '800800895', 'Resume for Maxa Million. <br/> <br/> Studied at The University of North Carolina at Charlotte <br/> B.S. Computer Science <br/> GPA 3.7 <br/> Member of the Coding Club');
INSERT INTO `SSDI_49erZone`.`Applications` (`Number`, `JobID`, `Name`, `UserID`, `Resume`) VALUES ('2', 'STU070', 'Dwayne Johnson', '800864222', 'Resume for Dwayne Johnson. <br/> <br/> Studied at The University of North Carolina at Charlotte <br/> B.A. Software and Information Systems <br/> GPA 3.4 <br/> Member of the Coding Club');

INSERT INTO `SSDI_49erZone`.`Job` (`JobID`, `JobTitle`, `Description`, `ShortDescription`) VALUES ('STU070', 'Web Designer','UNC Charlotte is seeking an undergraduate or graduate student (preferred) conversant and knowledgeable with designing a web site for a University consortium called CAPER. The website should be accessible by the public but some key areas will be made available to members via login password protocol. Salary = $7.25 and 10 hours per week.', 'Web Designer for Energy Production & Infrastructure Center (EPIC)');
INSERT INTO `SSDI_49erZone`.`Job` (`JobID`, `JobTitle`, `Description`, `ShortDescription`) VALUES ('STU083', 'Student Building Services', 'Working with full-time staff to perform room changeovers, empty trashcans, and cleaning and maintaining restrooms.  Assist Full time staff as requested in maintaining departmental office spaces. All other duties as assigned. Salary = $8.40 and 20 hours per week.', 'Cone Center Operations');
INSERT INTO `SSDI_49erZone`.`Job` (`JobID`, `JobTitle`, `Description`, `ShortDescription`) VALUES ('STU104', 'Research Assistant', 'Provide administrative assistance for a faculty member\'s grant project. Primary responsibility will be transcribing audio recordings of focus group discussions on barriers to employment and resources that would be helpful to be fully employed.  Other responsibilities may include, but are not limited to, correspondence, taking notes, entering data into a database, and coding.  Salary = $7.25 and 10 hours per week.', 'CLAS Pol Sci Office Staff');


CREATE TABLE `comment` (
  `Newsid` varchar(20) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `comment` varchar(45) NOT NULL
) ;



	INSERT INTO `ssdi_49erzone`.`user`
(`UserID`,
`FirstName`,
`LastName`,
`EmailAddress`,
`Address`,
`City`,
`State`,
`Country`,
`ZIP`,
`DateOfBirth`,
`PhoneNum`,
`Course`,
`Department`,
`Club`,
`Gender`,
`UserType`,
`userpassword`,
`Ques1`,
`Ans1`,
`Ques2`,
`Ans2`)
VALUES
("800864817",
"John",
"Smith",
"John.Smith@gmail.com",
"207 UT Drive Apt 311",
"Charlotte",
"North Carolina",
"USA",
"28003",
1995-09-09,
9803332222,
"Applied Database",
"Information Technology",
"Alpha Kappa PHI",
"M",
000,
"*****",
"What is your favourite sport?",
"Tennis",
"What is your pets name",
"Spike");


INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12345',
'Casual T shirt',
'UNCC product',
'Clothing',
'Dress Material',
14.00,
'images/casualshirt.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`ItemDescription`,
`CatalogName`,
`CatalogDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12346',
'U neck shirt',
'UNCC product',
'Clothing',
'Dress Material',
12.00,
'images/tshirt.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12347',
'Hoodie',
'UNCC product',
'Clothing',
'Dress Material',
12.00,
'images/hoodie.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12348',
'Tank Top',
'UNCC product',
'Clothing',
'Dress Material',
12.00,
'images/tanktop.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12349',
'Baseball Cap',
'UNCC product',
'Accessories',
'UNCC cap customized for baseball players. Avialable in free size',
15.00,
'images/cap.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12350',
'Regular Cap',
'UNCC product',
'Accessories',
'UNCC cap customized for all students. Avialable in free size',
12.00,
'images/cap2.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12351',
'Winter Cap',
'UNCC product',
'Accessories',
'UNCC cap customized for all students. Avialable in free size',
11.00,
'images/cap3.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12352',
'Track Pant',
'UNCC product',
'Clothing',
'UNCC track pant customized for all students. Avialable in all sizes',
20.00,
'images/pant.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12353',
'Belt',
'UNCC product',
'Accessories',
'UNCC belt customized for all students. Avialable in all sizes',
20.00,
'images/belt.jpg');

INSERT INTO `ssdi_49erzone`.`item`
(`ItemID`,
`ItemName`,
`CatalogDescription`,
`CatalogName`,
`ItemDescription`,
`ItemPrice`,
`ImageURL`)
VALUES
('12354',
'Wall Clock',
'UNCC product',
'Accessories',
'UNCC logo wall clock.',
20.00,
'images/watch.jpg');


INSERT INTO `ssdi_49erzone`.`user`
(`UserID`,
`FirstName`,
`LastName`,
`EmailAddress`,
`Address`,
`City`,
`State`,
`Country`,
`ZIP`,
`DateOfBirth`,
`PhoneNum`,
`Course`,
`Department`,
`Club`,
`Gender`,
`UserType`,
`userpassword`,
`Ques1`,
`Ans1`,
`Ques2`,
`Ans2`)
VALUES
("800864222",
"Dwayne",
"Johnson",
"dan.john@gmail.com",
"3901 providence road",
"Charlotte",
"North Carolina",
"USA",
"28263",
09-20-1993,
2809876543,
"NBAD",
"Information Technology",
"Alpha Kappa PHI",
"M",
000,
"beemer",
"What is your favourite sport",
"Football",
"What is your pets name",
"Zoey");

INSERT INTO `ssdi_49erzone`.`user`
(`UserID`,
`FirstName`,
`LastName`,
`EmailAddress`,
`Address`,
`City`,
`State`,
`Country`,
`ZIP`,
`DateOfBirth`,
`PhoneNum`,
`Course`,
`Department`,
`Club`,
`Gender`,
`UserType`,
`userpassword`,
`Ques1`,
`Ans1`,
`Ques2`,
`Ans2`)
VALUES
("800224455",
"Laura",
"Laniere",
"Lancy.l@gmail.com",
"901apt Vinoy blvd",
"Charlotte",
"North Carolina",
"USA",
"28262",
12-12-1985,
9000897683,
"PISP",
"Computer Science",
"CRAVE College life",
"F",
000,
"sakura",
"What is your favourite sport",
"squash",
"What is your pets name",
"mike");




INSERT INTO `ssdi_49erzone`.`user`
(`UserID`,
`FirstName`,
`LastName`,
`EmailAddress`,
`Address`,
`City`,
`State`,
`Country`,
`ZIP`,
`DateOfBirth`,
`PhoneNum`,
`Course`,
`Department`,
`Club`,
`Gender`,
`UserType`,
`userpassword`,
`Ques1`,
`Ans1`,
`Ques2`,
`Ans2`)
VALUES
("800800895",
"Maxa",
"Million",
"millions@gmail.com",
"3908 W.T harris blvd",
"Charlotte",
"North Carolina",
"USA",
"28262",
12-01-1990,
9000899873,
"HCI",
"Computer Science",
"Club baseball",
"F",
000,
"ranch",
"What is your favourite sport",
"baseball",
"What is your pets name",
"mills");


select * from user;


INSERT INTO `ssdi_49erzone`.`user`
(`UserID`,
`FirstName`,
`LastName`,
`EmailAddress`,
`Address`,
`City`,
`State`,
`Country`,
`ZIP`,
`DateOfBirth`,
`PhoneNum`,
`Course`,
`Department`,
`Club`,
`Gender`,
`UserType`,
`userpassword`,
`Ques1`,
`Ans1`,
`Ques2`,
`Ans2`)
VALUES
("800995564",
"Katelyn",
"Nicole",
"katty@gmail.com",
"1190 poplar tent road",
"Charlotte",
"North Carolina",
"USA",
"29913",
09-20-1989,
9086567973,
"NBAD",
"Information Technology",
"C4 charlotte",
"F",
000,
"crystal",
"What is your favourite sport",
"Batminton",
"What is your pets name",
"bluey");

INSERT INTO `ssdi_49erzone`.`news`
(`NewsID`,
`NewsTitle`,
`Description`)
VALUES
(1,
"Ahead of Union Budget",
"Ahead of next Union Budget, finance minister Arun Jaitley today hinted at a cut in grants from the Centre to states, saying the states will have to stand on their own by generating ");

INSERT INTO `ssdi_49erzone`.`news`
(`NewsID`,
`NewsTitle`,
`Description`)
VALUES
(2,
"Niner Times",
"Ahead of next Union Budget, finance minister Arun Jaitley today hinted at a cut in grants from the Centre to states, saying the states will have to stand on their own by generating ");

INSERT INTO `ssdi_49erzone`.`eventdb`
(`EventID`,
`EventTitle`,
`eventdescription`,
`eventfare`)
VALUES
(1,
"Intermediate Excel 2013",
"This course will introduce Excel users to charting features and database management in Microsoft Excel 2013. Participants will design worksheets that meet Excel criteria for database functions such as sorting and filtering.",
7.0);

INSERT INTO `ssdi_49erzone`.`eventdb`
(`EventID`,
`EventTitle`,
`eventdescription`,
`eventfare`)
VALUES
(2,
"Process Innovation",
"The tools and techniques of Process Innovation go beyond finding creative solutions to business process challenges; they provide the context and direction so that your organization's investment in process change yields meaningful and lasting returns",
5.0);

