DROP TABLE IF EXISTS HOSPITALS;

create table HOSPITALS (
    ID int not null primary key,
    NAME varchar(100) not null,
    GPS_POSITION varchar(100) not null,
    MAIL varchar(100) not null
);
INSERT INTO hospitals (id, name, gps_position, mail)
  VALUES (1, 'CHU de Nantes','-122.418563,37.751659', 'chu.nantes@gmail.com' ),
                 (2, 'CHU de Nantes Sud','-122.422969,37.75529', 'chu.paris@gmail.com' );

DROP TABLE IF EXISTS DEPARTMENTS;
create table DEPARTMENTS (
    ID int not null primary key,
    HOSPITAL_ID int,
    FOREIGN KEY (HOSPITAL_ID) REFERENCES Hospitals(ID),
    TYPE varchar(100) not null
);

INSERT INTO departments (id, hospital_id, type)
  VALUES (1, 1,'radiologie'),
                 (2, 2, 'réanimation'),
                 (3, 2, 'radiologie'),
                 (4, 1, 'réanimation');

DROP TABLE IF EXISTS PATIENTS;

create table PATIENTS (
    ID int not null IDENTITY(1,1) primary key,
    LAST_NAME varchar(100) not null,
    FIRST_NAME varchar(100) not null
);

DROP TABLE IF EXISTS ROOMS;

create table ROOMS (
    ID int not null primary key,
    DEPARTMENT_ID int,
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES Departments(ID)
);


INSERT INTO rooms (id, department_id)
  VALUES (1, 1),
                 (2, 1),
                 (3, 2),
                 (4, 2),
                 (5, 3),
                 (6, 3),
                 (7, 4),
                 (8, 4),
                 (9, 4);

DROP TABLE IF EXISTS BEDS;

create table BEDS (
    ID int not null primary key,
    ROOM_ID int,
    FOREIGN KEY (ROOM_ID) REFERENCES Rooms(ID)
);

INSERT INTO beds (id, room_id)
  VALUES (1, 1),
                 (2, 1),
                 (3, 2),
                 (4, 2),
                 (5, 3),
                 (6, 3),
                 (7, 4),
                 (8, 4),
                 (9, 5),
                 (10, 5),
                 (11, 6),
                 (12, 6),
                 (13, 7),
                 (14, 7),
                 (15, 8),
                 (16, 8),
                 (17, 9);

DROP TABLE IF EXISTS RESERVATIONS;

create table RESERVATIONS (
    ID int not null IDENTITY(1,1) primary key,
    BED_ID int,
    PATIENT_ID int,
    START_DATE date,
    END_DATE date
);
