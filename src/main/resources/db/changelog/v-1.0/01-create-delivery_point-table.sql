CREATE TABLE IF NOT EXISTS delivery_points (
    id_name varchar (20) primary key ,
    display_name varchar (50) not null ,
    partial_purchase boolean,
    active boolean,
    coordinate_l float,
    coordinate_w float,
    address_appartment varchar (10),
    address_building varchar (10),
    address_country varchar (5),
    address_phone varchar (20),
    address_street_name varchar (50),
    address_street_number varchar (5),
    address_town_name varchar (10)
    );