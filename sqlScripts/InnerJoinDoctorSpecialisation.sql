create table specialisation(
                     id serial primary key,
                     name varchar(255)
);

create table doctor(
                        id serial primary key,
                        name varchar(255),
                        reception date,
                        specialisation_id int references specialisation(id)
                        
);

insert into specialisation(name) values ('dentist');
insert into specialisation(name) values ('surgeon');
insert into specialisation(name) values ('neurologist');

insert into doctor(name, specialisation_id, reception) values ('Ivan', 1, '2021-04-14');
insert into doctor(name, specialisation_id, reception) values ('Boris', 2, '2019-02-11');
insert into doctor(name, specialisation_id, reception) values ('Petr', 3, '2020-05-17');
insert into doctor(name, reception) values ('Vasya', '2022-03-10');
insert into doctor(name, reception) values ('Anya', '2021-07-27');

select d.name, s.name, d.reception
from doctor as d
         join specialisation as s
              on d.specialisation_id = s.id;

select d.name as "Имя доктора", s.name as Специализация, d.reception as "Дата приема"
from doctor as d
         join specialisation as s
              on d.specialisation_id = s.id;

select d.name as "Имя доктора", s.name as Специализация, d.reception as "Дата приема"
from doctor as d
         join specialisation as s
              on d.specialisation_id = s.id
where s.name = 'surgeon';


select d.name as "Имя доктора", s.name as Специализация, d.reception as "Дата приема"
from doctor as d
         join specialisation as s
              on d.specialisation_id = s.id
where d.reception > '2021-01-01';
