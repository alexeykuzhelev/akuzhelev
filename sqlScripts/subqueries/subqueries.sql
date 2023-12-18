CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers (first_name, last_name, age, country) values ('Иванов', 'Иван', 35, 'Латвия');
insert into customers (first_name, last_name, age, country) values ('Петров', 'Петр', 47, 'Россия');
insert into customers (first_name, last_name, age, country) values ('Абрамов', 'Абрам', 65, 'США');
insert into customers (first_name, last_name, age, country) values ('Романов', 'Роман', 17, 'Белорусия');
insert into customers (first_name, last_name, age, country) values ('Денисов', 'Денис', 28, 'Германия');

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders (amount, customer_id) values (200, 1);
insert into orders (amount, customer_id) values (250, 2);
insert into orders (amount, customer_id) values (300, 3);

-- Список клиентов, возраст которых является минимальным
select c.first_name as Фамилия, c.last_name as Имя from customers c
where c.age = (select min(age) from customers);

-- Список пользователей, которые еще не выполнили ни одного заказа
select c.first_name as Фамилия, c.last_name as Имя from customers c
where c.id not in (select customer_id from orders);
