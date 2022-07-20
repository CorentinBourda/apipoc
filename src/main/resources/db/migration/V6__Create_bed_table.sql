create table BEDS (
    ID int not null primary key,
    ROOM_ID int,
    FOREIGN KEY (ROOM_ID) REFERENCES Rooms(ID)
);
