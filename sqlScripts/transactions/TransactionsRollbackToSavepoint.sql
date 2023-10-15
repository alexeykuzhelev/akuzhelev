create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 38, 225);
delete from products where name = 'product_2';
savepoint first_savepoint;
select * from products;
delete from products where name = 'product_3';
savepoint second_savepoint;
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 57, 168);
select * from products;
rollback to second_savepoint;
select * from products;
rollback to first_savepoint;
select * from products;
rollback;
select * from products;

begin transaction;
savepoint first_savepoint;
select * from products;
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 38, 225);
savepoint second_savepoint;
select * from products;
delete from products where name = 'product_3';
select * from products;
update products set price = 75 where name = 'product_1';
savepoint three_savepoint;
select * from products;
release savepoint second_savepoint;
select * from products;
rollback to three_savepoint;
select * from products;
rollback to first_savepoint;
select * from products;
commit;

begin transaction;
delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;
savepoint first_savepoint;
select * from products;
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 7, 48);
savepoint second_savepoint;
select * from products;
drop table products;
rollback to second_savepoint;
select * from products;
rollback to first_savepoint;
commit;
select * from products;
