create table HOSPITALS (
    ID int not null primary key,
    NAME varchar(100) not null,
    GPS_POSITION varchar(100) not null,
    MAIL varchar(100) not null
);
INSERT INTO hospitals (name, gps_position, mail)
  VALUES ('CHU de Nantes','48.82651,2', 'chu.nantes@gmail.com' ),
                 ('CHU de Paris','23.82651,2', 'chu.paris@gmail.com' ),
                 ('CHU de Bordeaux','90.82651,2', 'chu.bordeaux@gmail.com' ),
                 ('CHU de Lile','67.82651,2', 'chu.lile@gmail.com' ),
                 ('CHU de Marseille','47.82651,2', 'chu.marseille@gmail.com' ),
                 ('CHU de Rennes','46.82651,2', 'chu.rennes@gmail.com' ),
                 ('CHU de Brest','45.82651,2', 'chu.brest@gmail.com' ),
                 ('CHU de Toulouse','44.82651,2', 'chu.toulouse@gmail.com' );
