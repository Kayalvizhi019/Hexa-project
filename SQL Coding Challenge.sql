drop database if exists CRS;
create database CRS;
use CRS;
drop table if exists vehicle;
drop table if exists customer;
drop table if exists lease;
drop table if exists payment;

-- create Vehicle table
create table Vehicle (
vehicle_ID int primary key,
make varchar(20) ,
model varchar(20) ,
year int not null,
dailyRate numeric(9,2) ,
status enum('1','0') ,
passengerCapacity int ,
engineCapacity int 
);


insert into Vehicle (vehicle_ID,make,model,year,dailyrate,status,passengerCapacity,engineCapacity)
values (1,'Toyoto','Camry', 2022, 50.00,'1' , 4, 1450),
(2,'Honda','Civic', 2023 ,45.00,'1', 7, 1500),
(3,'Ford','Focus', 2022, 48.00,'0', 4, 1400),
(4,'Nissan','Altima', 2023, 52.00,'1', 7, 1200),
(5,'Chevrolet','Malibu', 2022, 47.00,'1', 4, 1800),
(6,'Hyundai','Sonata', 2023, 49.00,'0', 7, 1400),
(7,'BMW','3 series', 2023, 60.00,'1', 7, 2499),
(8,'Mercedes','C-Class', 2022, 58.00,'1',8, 2599),
(9,'Audi','A4', 2022, 55.00,'0', 4, 2500),
(10,'Lexus','ES', 2023, 54.00,'1', 4, 2500);


-- create customer table
create table customer
(
customerID int primary key,
firstName varchar(20) ,
lastName varchar(20) ,
email  varchar(50) ,
phoneNumber varchar(20) 
);


insert into Customer(customerID,firstName,lastName,email,phoneNumber)
values(1,'John','Doe','johndoe@example.com','555-555-5555'),
(2,'Jane','Smith','janesmith@example.com ','555-123-4567'),
(3,'Robert', 'Johnson', 'robert@example.com', '555-789-1234'),
(4,'Sarah', 'Brown', 'sarah@example.com', '555-456-7890'),
(5,'David', 'Lee', 'david@example.com', '555-987-6543'),
(6,'Laura', 'Hall', 'laura@example.com', '555-234-5678'),
(7,'Michael', 'Davis', 'michael@example.com', '555-876-5432'),
(8,'Emma', 'Wilson', 'emma@example.com', '555-432-1098'),
(9,'William', 'Taylor', 'william@example.com', '555-321-6547'),
(10,'Olivia', 'Adams', 'olivia@example.com', '555-765-4321');

-- create lease table
create table Lease
(
leaseID int primary key,
vehicle_ID int,
customerID int,
startDate Date ,
endDate Date ,
type enum('Daily','Monthly') ,
foreign key (vehicle_ID) references vehicle(vehicle_ID),
foreign key (customerID) references customer(customerID)
);


insert into Lease(leaseID,vehicle_ID,customerID,startDate,endDate,type)
values(1, 1, 1, '2023-01-01', '2023-01-05', 'Daily'),
(2, 2, 2, '2023-02-15', '2023-02-28', 'Monthly'),
(3, 3, 3, '2023-03-10', '2023-03-15', 'Daily'),
(4, 4, 4, '2023-04-20', '2023-04-30', 'Monthly'),
(5, 5, 5, '2023-05-05', '2023-05-10', 'Daily'),
(6, 4, 3, '2023-06-15', '2023-06-30', 'Monthly'),
(7, 7, 7, '2023-07-01', '2023-07-10', 'Daily'),
(8, 8, 8, '2023-08-12', '2023-08-15', 'Monthly'),
(9, 3, 3, '2023-09-07', '2023-09-10', 'Daily'),
(10, 10, 10, '2023-10-10', '2023-10-31', 'Monthly');


-- create payment table
create table Payment
(
paymentID int primary key,
leaseID int,
paymentDate Date ,
amount numeric(9,2) ,
foreign key (leaseID) references lease(leaseID)
);


insert into payment(paymentID,leaseID,paymentDate,amount)
values(1, 1, '2023-01-03', 200.00),
(2, 2, '2023-02-20', 1000.00),
(3, 3, '2023-03-12', 75.00),
(4, 4, '2023-04-25', 900.00),
(5, 5, '2023-05-07', 60.00),
(6, 6, '2023-06-18', 1200.00),
(7, 7, '2023-07-03', 40.00),
(8, 8, '2023-08-14', 1100.00),
(9, 9, '2023-09-09', 80.00),
(10, 10, '2023-10-25', 1500.00);

select * from vehicle;
select * from customer;
select * from lease;
select * from payment;


-- 1. Update the daily rate for a Mercedes car to 68. 

update Vehicle
set dailyRate = 68
where vehicle_ID = 8;

-- 2. Delete a specific customer and all associated leases and payments. 

delete from payment
where leaseID IN (select leaseID from lease where customerID = 6);

delete from lease
where customerID = 6;

delete from customer
where customerID = 6;

-- 3. Rename the "paymentDate" column in the Payment table to "transactionDate". 

alter table Payment
rename column paymentDate to transactionDate;

-- 4. Find a specific customer by email. 

select * from customer
where email = 'robert@example.com';

-- 5. Get active leases for a specific customer. 

select lease.* , customer.customerID
from lease 
inner join customer on
lease.customerID = customer.customerID
where customer.customerID = 1; 

-- 6. Find all payments made by a customer with a specific phone number. 

select p.*
from payment p
join lease l ON p.leaseID = l.leaseID
join customer c ON l.customerID = c.customerID
where c.phoneNumber = '555-789-1234';

-- 7. Calculate the average daily rate of all available cars. 

 select status as Available_Cars, avg(dailyRate) from vehicle
where status = '1'
group by status;

-- 8. Find the car with the highest daily rate.

select * from vehicle 
where dailyRate =  (select max(distinct dailyRate) from vehicle);

-- 9. Retrieve all cars leased by a specific customer. 

select v.*
from vehicle v
join lease l ON v.vehicle_ID = l.vehicle_ID
join customer c ON l.customerID = c.customerID
where c.customerID = '1';

-- 10.Find the details of the most recent lease. 

select * 
from lease
order by startDate desc
limit 1;

-- 11. List all payments made in the year 2023.
 
select * from
payment
where transactionDate between '2023-01-01' and '2023-12-31';

-- 12. Retrieve customers who have not made any payments. 

select distinct c.*
from customer c
left join lease l on
l.customerID = c.customerID
left join payment p on
p.leaseID = l.leaseID
where p.paymentID is NULL ;

-- 13. Retrieve Car Details and Their Total Payments. 

select v.vehicle_ID, v.make, v.model, v.year, v.dailyRate, SUM(p.amount) AS totalPayments
from vehicle v
join lease l ON v.vehicle_ID = l.vehicle_ID
join payment p ON l.leaseID = p.leaseID
group by v.vehicle_ID;

-- 14. Calculate Total Payments for Each Customer.

select c.customerID, c.firstName, c.lastName, SUM(p.amount) AS totalPayments
from customer c
join lease l ON c.customerID = l.customerID
join payment p ON l.leaseID = p.leaseID
group by c.customerID;

-- 15. List Car Details for Each Lease. 

select l.leaseID, v.vehicle_ID, v.make, v.model, v.year, v.dailyRate
from lease l
join vehicle v ON l.vehicle_ID = v.vehicle_ID;

-- 16. Retrieve Details of Active Leases with Customer and Car Information. 

select l.leaseID, l.startDate, l.endDate, c.firstName, c.lastName, v.make, v.model, v.year, v.dailyRate
from lease l
inner join customer c on l.customerID = c.customerID
inner join  vehicle v on l.vehicle_ID = v.vehicle_ID
where l.endDate >= '2023-07-01'; 

-- 17.  Find the Customer Who Has Spent the Most on Leases. 

select c.customerID, c.firstName, c.lastName, SUM(p.amount) AS totalSpent
from customer c
join lease l ON c.customerID = l.customerID
join payment p ON l.leaseID = p.leaseID
group by c.customerID
order by totalSpent DESC
limit 1;

-- 18. List All Cars with Their Current Lease Information. 

select v.vehicle_ID, v.make, v.model, v.year, v.dailyRate, l.startDate, l.endDate, c.firstName, c.lastName
from vehicle v
left join lease l ON v.vehicle_ID = l.vehicle_ID AND l.endDate >= CURDATE()  
left join customer c ON l.customerID = c.customerID;



