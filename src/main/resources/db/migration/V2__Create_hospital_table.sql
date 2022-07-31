create table HOSPITALS (
    ID int not null primary key,
    NAME varchar(100) not null,
    GPS_POSITION varchar(100) not null,
    MAIL varchar(100) not null
);
INSERT INTO hospitals (name, gps_position, mail)
  VALUES ('CHU de Nantes','47.2108967,-1.5533024', 'chu.nantes@gmail.com' ),
                 ('CHU de Nantes Sud','47.1410204,-1.5329331', 'chu.paris@gmail.com' ),
                 ('CHU de Nantes Ouest','47.175831,-1.624034', 'chu.bordeaux@gmail.com' ),
                 ('CHU de Nantes Nord','47.2979523,-1.5524545', 'chu.lile@gmail.com' ),
                 ('CHU de Nantes Est','47.2001896,-1.4284585', 'chu.marseille@gmail.com' ),
                 ('CHU de Bordeaux','44.827436,-0.6055796', 'chu.rennes@gmail.com' ),
                 ('CHU de Bordeaux Sud','44.7479453,-0.5917332', 'chu.brest@gmail.com' ),
                 ('CHU de Bordeaux Nord','44.9056836,-0.5082626', 'chu.toulouse@gmail.com' );
