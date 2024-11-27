drop database if exists hospitalmanagement;
create database hospitalmanagement;
use hospitalmanagement;
drop table if exists Doctor_master;
drop table if exists Room_master;
drop table if exists Patient_master;
drop table if exists room_allocation;

-- Create doctor_master table
create table Doctor_master (
    doctor_id varchar(15) primary key not null,
    doctor_name varchar(15) not null,
    dept varchar(15) not null
);

-- Insert sample data into doctor_master
insert into doctor_master (doctor_id,doctor_name,dept) 
values ('D0001','Ram','ENT'),
('D0002','Rajan','ENT'),
('D0003','Smita','Eye'),
('D0004','Bhavan','Surgery'),
('D0005','Sheela','Surgery'),
('D0006','Nethra','Surgery');


-- Create room_maste table
create table room_master (
    room_no varchar(15) primary key not null,
    room_type varchar(15) not null,
    status varchar(15) not null
);


-- Insert sample data into room_master
insert into room_master (room_no, room_type, status) 
values ('R0001','AC','occupied'),
('R0002','Suite','vacant'),
('R0003','NonAC','vacant'),
('R0004','NonAC','occupied'),
('R0005','AC','vacant'),
('R0006','AC','occupied');


-- Create patient_master table
create table patient_master (
    pid varchar(15) primary key not null,
    name varchar(15) not null,
    age int(15) not null,
    weight int(15) not null,
    gender varchar(10) not null,
    address varchar(50) not null,
    phoneno varchar(10) not null,
    disease varchar(50) not null,
    doctorid varchar(5),
    foreign key (doctorid) references doctor_master(doctor_id)
);

-- Insert sample data into patient_master
insert into patient_master (pid, name, age, weight, gender, address, phoneno, disease, doctorid) 
values ('P0001','Gita',35,65,'F','Chennai','9867145678','Eye Infection','D0003'),
('P0002','Ashish',40,70,'M','Delhi','9845675678','Asthma','D0003'),
('P0003','Radha',25,60,'F','Chennai','9867166678','Pain in heart','D0005'),
('P0004','Chandra',28,55,'F','Bangalore','9978675567','Asthma','D0001'),
('P0005','Goyal',42,65,'M','Delhi','8967533223','Pain in Stomach','D0004');


-- Create room_allocation table
create table room_allocation (
    room_no varchar(15) not null,
    pid varchar(15) not null,
    admission_date Date not null,
    release_date Date,
    foreign key (room_no) references room_master(room_no),
     foreign key (pid) references patient_master(pid)
);

-- Insert sample data into room_allocation
insert into room_allocation (room_no, pid, admission_date, release_date) VALUES
('R0001','P0001','2016-10-15','2016-10-26'),
('R0002','P0002','2016-11-15','2016-11-26'),
('R0002','P0003','2016-12-01','2016-12-30'),
('R0004','P0001','2017-01-01','2017-01-30');


-- Query 1: Display the patients who were admitted in the month of January.

SELECT * FROM ROOM_ALLOCATION
WHERE MONTH(admission_date) = 1;


-- Query 2: Display the female patient who is not suffering from asthma.

SELECT * FROM PATIENT_MASTER
WHERE gender = 'F' AND disease <> 'Asthma';


-- Query 3: Count the number of male and female patients.

SELECT gender, COUNT(*) AS count
FROM PATIENT_MASTER
GROUP BY gender;

-- Query 4: Display the patient_id, patient_name, doctor_id, doctor_name, room_no, room_type, and admission_date.

SELECT p.pid AS patient_id, p.name AS patient_name, d.doctor_id, d.doctor_name,
       r.room_no, r.room_type, ra.admission_date
FROM PATIENT_MASTER p
JOIN DOCTOR_MASTER d ON p.doctorid = d.doctor_id
JOIN ROOM_ALLOCATION ra ON p.pid = ra.pid
JOIN ROOM_MASTER r ON ra.room_no = r.room_no;


-- Query 5: Display the room_no which was never allocated to any patient.

SELECT room_no
FROM ROOM_MASTER
WHERE room_no NOT IN (SELECT room_no FROM ROOM_ALLOCATION);


-- Query 6: Display the room_no, room_type which are allocated more than once.

SELECT ra.room_no, rm.room_type
FROM ROOM_ALLOCATION ra
JOIN ROOM_MASTER rm ON ra.room_no = rm.room_no
GROUP BY ra.room_no, rm.room_type
HAVING COUNT(ra.room_no) > 1;
