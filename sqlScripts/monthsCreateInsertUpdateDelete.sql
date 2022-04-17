create table months (
    id serial primary key,
    name_month varchar(10),
    days int,
    full_date date
);

insert into months(name_month, days, full_date) values ('February', 29, '2022-02-16');

update months set days=28;

delete from months;
