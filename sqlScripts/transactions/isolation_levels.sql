create table address(
    id serial primary key,
    city varchar(255),
    street varchar(255),
    building varchar(255)
);

insert into address(city, street, building) values ('Moscow', 'Tverskaya', 33);
insert into address(city, street, building) values ('Moscow', 'Popova', 51);
insert into address(city, street, building) values ('Moscow', 'Gagarina', 74);

-- Первая транзакция:
begin transaction isolation level serializable;

-- Вторая транзакция:
begin transaction isolation level serializable;

-- Первая транзакция:
SELECT sum (building) FROM address;
insert into address(city, street, building) values ('Moscow', 'Lenina', 12);
update address set building = 85 where street = 'Gagarina';

-- Вторая транзакция:
SELECT sum (building) FROM address;
insert into address(city, street, building) values ('Moscow', 'Konovalova ', 23);
update address set building = 17 where street = 'Popova';

commit;

-- Первая транзакция:
commit;

-- Очистка таблицы для повторных операций
delete from address;
ALTER SEQUENCE address_id_seq RESTART WITH 1;

