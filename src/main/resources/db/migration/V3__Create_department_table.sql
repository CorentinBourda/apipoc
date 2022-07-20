create table DEPARTMENTS (
    ID int not null primary key,
    HOSPITAL_ID int,
    FOREIGN KEY (HOSPITAL_ID) REFERENCES Hospitals(ID),
    TYPE varchar(100) not null
);
