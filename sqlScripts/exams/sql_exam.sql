-- 1. NaN из . Какой запрос даст верный результат

create table t_one(
    id serial primary key,
    field_1 int
);

create table t_two(
    id serial primary key,
    field_2 int
);

create table t_three(
    id serial primary key,
    field_3 int
);

insert into t_one(id, field_1) values (5, 30), (7, 2), (9, 10);
insert into t_two(id, field_2) values (5, 1), (7, 20), (9, null);
insert into t_three(id, field_3) values (5, null), (7, 5), (9, 3);

select field_3 * field_1 + field_2 as result
from t_one
left join t_two
on t_one.id = t_two.id
right join t_three
on t_three.id = t_one.id
where t_one.id = 7;

select field_3 * field_2 + field_1 as result
from t_one
left join t_two
on t_one.id = t_two.id
left join t_three
on t_three.id = t_one.id
where t_one.id = 5;

select field_3 * field_1 + field_2 as result
from t_one
left join t_three
on t_one.id = t_three.id
left join t_two
on t_two.id = t_three.id
where t_one.id = 9;

-- 2. 2 из 5. Какая из таблиц в запросе является главной

select * from t_one
right join t_two on t_two.id = t_one.id
right join t_three on t_three.id = t_two.id;

-- 3. 5 из 5. Какой результат будет отображён после выполнения запроса

select *
from t_one
inner join t_two
on t_two.id = t_one.id;

