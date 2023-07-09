create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax_after()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id in (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_after_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_after();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);

create or replace function tax_before()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_before_trigger
    before insert on products
    for each row
    execute procedure tax_before();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 10, 150);
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 20, 200);

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function add_history()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
        values (new.name, new.price, CURRENT_TIMESTAMP);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_history_trigger
    after insert on products
    for each row
    execute procedure add_history();

insert into products (name, producer, count, price) VALUES ('product_6', 'producer_5', 15, 250);
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 25, 350);


