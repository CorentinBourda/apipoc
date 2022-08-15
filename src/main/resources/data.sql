DROP TABLE IF EXISTS HOSPITALS;

create table HOSPITALS (
    ID int not null primary key,
    NAME varchar(100) not null,
    GPS_POSITION varchar(100) not null,
    MAIL varchar(100) not null
);
INSERT INTO hospitals (id, name, gps_position, mail)
  VALUES (1, 'CHU de Nantes','47.2108967,-1.5533024', 'chu.nantes@gmail.com' ),
                 (2, 'CHU de Nantes Sud','47.1410204,-1.5329331', 'chu.paris@gmail.com' ),
                 (3, 'CHU de Nantes Ouest','47.175831,-1.624034', 'chu.bordeaux@gmail.com' ),
                 (4, 'CHU de Nantes Nord','47.2979523,-1.5524545', 'chu.lile@gmail.com' ),
                 (5, 'CHU de Nantes Est','47.2001896,-1.4284585', 'chu.marseille@gmail.com' ),
                 (6, 'CHU de Bordeaux','44.827436,-0.6055796', 'chu.rennes@gmail.com' ),
                 (7, 'CHU de Bordeaux Sud','44.7479453,-0.5917332', 'chu.brest@gmail.com' ),
                 (8, 'CHU de Bordeaux Nord','44.9056836,-0.5082626', 'chu.toulouse@gmail.com' );

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
