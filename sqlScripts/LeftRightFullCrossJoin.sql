create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values ('Department 1'), ('Department 2'), ('Department 3'), ('Department 4');
insert into employees(name, department_id) values ('Vlad', 1), ('Gleb', 2), ('Oleg', 1)
insert into employees(name, department_id) values ('Petr', null), ('Maxim', null), (null, 3);
insert into employees(name, department_id) values ('Olga', 3), ('Vladimir', 2);

--1. Выполнить запросы с left, rigth, full, cross соединениями
select * from departments d
left join employees e
on d.id = e.department_id;

select * from departments d
right join employees e
on d.id = e.department_id;

select * from departments d
full join employees e
on d.id = e.department_id;

select * from departments cross join employees;

--3. Используя left join найти департаменты, у которых нет работников
select * from departments d
left join employees e
on d.id = e.department_id
where e.id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат
--(порядок вывода колонок в эти запросах также должен быть идентичный).
select d.name, e.name from departments d
left join employees e
on d.id = e.department_id;

select d.name, e.name from employees e
right join departments d
on e.department_id = d.id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Vlad', 'man'), ('Gleb', 'man'), ('Oleg', 'man');
insert into teens(name, gender) values ('Olga', 'woman'), ('Anna', 'woman'), ('Natalia', 'woman');

select concat(t1.name, ' - ', t1.gender) as "Имя и пол", concat(t2.name, ' - ', t2.gender) as "Имя и противоположный пол"
from teens t1
cross join teens t2
where t1.gender != t2.gender;

