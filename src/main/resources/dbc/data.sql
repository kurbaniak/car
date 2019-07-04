drop table if exists cars_table;
create table cars_table(
id int auto_increment primary key,
car_name varchar (10) not null,
car_type varchar (10),
car_engine double (3),
car_year int (4)
);

insert into cars_table(car_name, car_type, car_engine, car_year) values ('Mazda', 'CX-5', 2.5, 2016);
insert into cars_table(car_name, car_type, car_engine, car_year) values ('Mazda', '6', 2.0, 2008);
insert into cars_table(car_name, car_type, car_engine, car_year) values ('Honda', 'Accord', 2.2, 2009);
-- insert into cars(name, type, engine, year) values ('Mazda', '6', 2.0, 2008);

