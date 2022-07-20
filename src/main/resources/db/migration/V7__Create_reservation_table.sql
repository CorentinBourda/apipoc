create table RESERVATIONS (
    ID int not null primary key,
    BED_ID int,
    PATIENT_ID int,
    FOREIGN KEY (BED_ID) REFERENCES Beds(ID),
    FOREIGN KEY (PATIENT_ID) REFERENCES Patients(ID),
    START_DATE date not null,
    END_DATE date not null
);
