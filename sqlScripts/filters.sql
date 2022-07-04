create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price decimal
);

insert into type (name) values ('СЫР'),('МОЛОКО'), ('МОРОЖЕНОЕ'), ('МЯСО'),('ОВОЩИ');

insert into product(name, type_id, expired_date, price) values ('сыр адыгейский', 1, '2022-02-10', 125.50);
insert into product(name, type_id, expired_date, price) values ('сыр голландский', 1, '2022-02-11', 320.20);
insert into product(name, type_id, expired_date, price) values ('сыр пармезан', 1, '2022-03-15', 260.70);
insert into product(name, type_id, expired_date, price) values ('сгущенное молоко', 2, '2022-01-11', 105.50);
insert into product(name, type_id, expired_date, price) values ('молоко простоквашино', 2, '2022-04-17', 120);
insert into product(name, type_id, expired_date, price) values ('молоко деревенское', 2, '2022-04-19', 90.50);
insert into product(name, type_id, expired_date, price) values ('мороженое эскимо', 3, '2022-05-18', 70.40);
insert into product(name, type_id, expired_date, price) values ('мороженое пломбир', 3, '2022-04-13', 60.50);
insert into product(name, type_id, expired_date, price) values ('мороженое сливочное', 3, '2022-01-02', 80);
insert into product(name, type_id, expired_date, price) values ('мясо свинины', 4, '2022-05-19', 640.50);
insert into product(name, type_id, expired_date, price) values ('мясо баранины', 4, '2022-04-25', 820);
insert into product(name, type_id, expired_date, price) values ('мясо страусиное', 4, '2022-02-09', 850);
insert into product(name, type_id, expired_date, price) values ('лук ребчатый', 5, '2022-01-10', 35.50);
insert into product(name, type_id, expired_date, price) values ('свекла', 5, '2022-02-06', 65);
insert into product(name, type_id, expired_date, price) values ('картофель', 5, '2022-03-09', 53.50);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name as "Продукт", t.name as "Тип"
from product as p
join type as t
on p.type_id = t.id
where t.name = 'СЫР';

select p.name as "Продукт", t.name as "Тип"
from product as p
join type as t
on p.type_id = t.id
group by p.name, t.name
having t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product where name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select * from product as p where p.expired_date < '01.04.2022'

--4. Написать запрос, который выводит самый дорогой продукт.
select p.name as "Продукт", t.name as "Тип", p.price as "Цена"
from product as p
join type as t
on p.type_id = t.id
where p.price = (select max(price) from product);

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name as "Имя_типа", count(p.name) as "Количество"
from product as p
join type as t
on p.type_id = t.id
group by t.name
order by t.name asc;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name as "Продукт", t.name as "Тип"
from product as p
join type as t
on p.type_id = t.id
where t.name in ('СЫР', 'МОЛОКО');

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
--Под количеством подразумевается количество продуктов определенного типа.
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат,
--то количество продуктов типа "СЫР" будет 2.
select t.name as "Тип продуктов", count(p.name) as "Количество"
from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p.name) < 10;

--8. Вывести все продукты и их тип.
select p.name as "Продукт", t.name as "Тип"
from product as p
join type as t
on p.type_id = t.id

