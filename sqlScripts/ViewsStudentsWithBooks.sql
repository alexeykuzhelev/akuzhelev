create table students (
    id serial primary key,
    name varchar(50)
);

insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');

create table authors (
    id serial primary key,
    name varchar(50)
);

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');

create table books (
    id serial primary key,
    name varchar(200),
    author_id integer references authors(id)
);

insert into books (name, author_id) values ('Евгений Онегин', 1);
insert into books (name, author_id) values ('Капитанская дочка', 1);
insert into books (name, author_id) values ('Дубровский', 1);
insert into books (name, author_id) values ('Мертвые души', 2);
insert into books (name, author_id) values ('Вий', 2);

create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);

-- Запрос, в котором мы определим список студентов, у которых находится 2 и более книг одного и того же автора.
-- При этом в результирующей таблице должно быть отражено имя студента, количество книг, имя автора.
select s.name as Имя_Студента,
       count(b.name) as Количество_книг,
       substring(a.name from 1 for 9) || ' Сергеевич' || substring(a.name from position(' ' in a.name)) as Автор
from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
group by (s.name, a.name) having count(b.name) >= 2
order by s.name, count(a.name) desc, Автор desc;

-- CREATE VIEW создает представление запроса. Создаваемое представление не является материализованным.
-- Соответственно, указанный запрос будет выполняться при каждом обращении к представлению.
create view show_students_with_2_or_more_books
    as select s.name as "Имя Студента",
              count(b.name) as "Количество книг",
              substring(a.name from 1 for 9) || ' Сергеевич' || substring(a.name from position(' ' in a.name)) as Автор
from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
    group by (s.name, a.name)   having count(a.name) >= 2
    order by s.name, count(a.name) desc, Автор desc;

-- Выполнить запрос с помощью данного представления
select * from show_students_with_2_or_more_books;
