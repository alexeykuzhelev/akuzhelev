create table gender (
    id serial primary key,
    name varchar(10)
);

create table users (
    id serial primary key,
    full_name varchar(50),
    adress text,
    gender_id int references gender(id)
);

create table films (
    id serial primary key,
    ordered_films text
);

create table users_films (
    id serial primary key,
    users_id int references users(id),
    films_id int references films(id)
);

insert into gender(name) values ('мужской'), ('женский');

insert into users(full_name, adress, gender_id)
values ('Ольга Егорова', '1-й Казанский переулок, д.14', 2),
       ('Иванов Сергей', 'ул. Центральная, д.40, кв.74', 1),
       ('Иванов Сергей', 'ул. Ленина, д.7, кв.130', 1);

insert into films(ordered_films)
values ('Пираты карибского моря'),
       ('Матрица: революция'),
       ('Человек, который изменил всё'),
       ('Интерстеллар');

insert into users_films(users_id, films_id) values (1, 1), (1, 2), (2, 3), (2, 4), (3, 2);

select * from users_films;

select full_name, adress, ordered_films
from users u
         join users_films uf on u.id = uf.users_id
         join films f on uf.films_id = f.id

