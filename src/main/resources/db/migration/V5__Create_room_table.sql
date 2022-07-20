create table ROOMS (
    ID int not null primary key,
    DEPARTMENT_ID int,
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES Departments(ID)
);
