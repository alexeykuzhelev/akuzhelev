--1. Создание таблиц: Кузовы, Двигатели, Коробки передач, Автомобили
create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

--2. Заполнить таблицы данными
insert into car_bodies(name) values ('Седан'), ('Хэтчбэк'), ('Кабриолет'), ('Пикап');
insert into car_engines(name) values ('petrol'), ('diesel'), ('electric'), ('gas');
insert into car_transmissions(name) values ('механическая'), ('автоматическая'), ('гидравлическая');
insert into cars(name, body_id, engine_id, transmission_id) values('kia', 4, 1, 1), ('audi', 2, 3, 2), ('lada', 1, 4, 3);
insert into cars(name, body_id, engine_id) values('opel', 1, 3)

--3. Вывести список всех машин и все привязанные к ним детали
select c.name as car_name,
b.name as "body_name",
e.name as "engine_name",
t.name as "transmission_name"
from cars as c
left join car_bodies as b on c.body_id = b.id
left join car_engines as e on c.engine_id = e.id
left join car_transmissions as t on c.transmission_id = t.id;

--4. Вывести детали каждого типа, которые не используются НИ в одной машине: кузова, двигатели, коробки передач
select b.name as body_name from car_bodies as b left join cars as c on c.body_id = b.id where c.id is null;
select e.name as engine_name from car_engines as e left join cars as c on c.engine_id = e.id where c.id is null;
select t.name as transmission_name from car_transmissions as t left join cars as c on c.transmission_id = t.id where c.id is null;

