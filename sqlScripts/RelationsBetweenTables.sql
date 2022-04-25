 create table address(
    id serial primary key,
    city varchar(255),
    street varchar(255),
    building varchar(255)
);

create table people(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    address_id int references address(id)
);

insert into address(city, street, building) values ('Moscow', 'Tverskaya', 33);
insert into address(city, street, building) values ('Moscow', 'Lenina ', 12);
insert into people(first_name, last_name, address_id) values ('Ivanov', 'Ivan', 1);
insert into people(first_name, last_name, address_id) values ('Petrov', 'Petr', 1);

select * from address;
select * from people where id in (select id from address);

 create table patients(
     id serial primary key,
     first_name varchar(255),
     last_name varchar(255)
 );

 create table doctors(
     id serial primary key,
     first_name varchar(255),
     last_name varchar(255)
 );

 create table patients_doctors(
     id serial primary key,
     patients_id int references patients(id),
     doctor_id int references doctors(id)
 );

insert into patients(first_name, last_name) values ('Ivanov', 'Ivan');
insert into patients(first_name, last_name) values ('Petrov', 'Petr');
insert into patients(first_name, last_name) values ('Romanov', 'Roman');

insert into doctors(first_name, last_name) values ('Abramov', 'Abram');
insert into doctors(first_name, last_name) values ('Aleksandrov', 'Aleksandr');
insert into doctors(first_name, last_name) values ('Denisov', 'Denis');

insert into patients_doctors(patients_id, doctor_id) values (1, 1);
insert into patients_doctors(patients_id, doctor_id) values (1, 2);
insert into patients_doctors(patients_id, doctor_id) values (2, 2);
insert into patients_doctors(patients_id, doctor_id) values (2, 3);
insert into patients_doctors(patients_id, doctor_id) values (3, 3);

create table student(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255)
);

create table сontact_details(
    id serial primary key,
    address text,
    phone int,
    student_id int references student(id) unique
);

insert into student(first_name, last_name) values ('Ivanov', 'Ivan');
insert into student(first_name, last_name) values ('Petrov', 'Petr');

insert into сontact_details(address, phone, student_id) values ('123456, Russia, Moscow, Pushkina 5-2-78', '111111', 1);
insert into сontact_details(address, phone, student_id) values ('123456, Russia, Moscow, Tverskaya 13', '222222', 2);
