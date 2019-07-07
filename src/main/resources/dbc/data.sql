drop table if exists CARS;
create table CARS(
id int auto_increment primary key,
CAR_NAME varchar (10) not null,
CAR_TYPE varchar (10),
CAR_ENGINE double (3),
CAR_YEAR int (4)
);

insert into CARS(CAR_NAME, CAR_TYPE, CAR_ENGINE, CAR_YEAR) values ('Mazda', 'CX-5', 2.5, 2016);
insert into CARS(car_name, car_type, car_engine, car_year) values ('Skoda', 'Octavia', 1.8, 2018);
insert into CARS(car_name, car_type, car_engine, car_year) values ('Honda', 'Accord', 2.2, 2009);


