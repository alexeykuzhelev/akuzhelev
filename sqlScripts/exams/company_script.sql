create table company(
    id integer not null,
    name character varying,
    constraint company_pkey primary key (id)
);

create table person(
    id integer not null,
    name character varying,
    company_id integer references company(id),
    constraint person_pkey primary key (id)
);

insert into company (id, name) values (1, 'Yandex');
insert into company (id, name) values (2, 'Microsoft');
insert into company (id, name) values (3, 'Google');
insert into company (id, name) values (4, 'Facebook');
insert into company (id, name) values (5, 'Twitter');

insert into person (id, name, company_id) values (1, 'Vlad', 1);
insert into person (id, name, company_id) values (2, 'Gleb', 1);
insert into person (id, name, company_id) values (3, 'Oleg', 2);
insert into person (id, name, company_id) values (4, 'Petr', 2);
insert into person (id, name, company_id) values (5, 'Maxim', 2);
insert into person (id, name, company_id) values (6, 'Olga', 3);
insert into person (id, name, company_id) values (7, 'Ivan', 4);
insert into person (id, name, company_id) values (8, 'Maria', 4);
insert into person (id, name, company_id) values (9, 'Bob', 5);
insert into person (id, name, company_id) values (10, 'Anna', 5);

-- 1. В одном запросе получить
-- - имена всех person, которые не состоят в компании с id = 5;
-- - название компании для каждого человека.
select person.name as Имя, company.name as Компания
from person
join company
on person.company_id = company.id
where company.id != 5;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
-- Нужно учесть, что таких компаний может быть несколько.
select company.name as "Название компании",
count(person.name) as "Количество сотрудников"
from company
join person
on company.id = person.company_id
group by company.name
having count(person.name) = (
    select max(person_count)
    from (select count(person.name) as person_count
          from company
          join person
          on company.id = person.company_id
          group by company.name
         ) as "Количество сотрудников каждой компании"
);

