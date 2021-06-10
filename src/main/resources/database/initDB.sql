DROP TABLE IF EXISTS DeliveryPoints;

CREATE TABLE IF NOT EXISTS DeliveryPoints (
                                id_name varchar (20) primary key ,
                                displayName varchar (50) not null ,
                                partialPurchase boolean
);

