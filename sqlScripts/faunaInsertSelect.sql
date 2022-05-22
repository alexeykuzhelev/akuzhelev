insert into fauna(name, avg_age, discovery_date) values ('mouse', 1095, '1985-03-08');
insert into fauna(name, avg_age, discovery_date) values ('horse', 20075, '1878-05-07');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 64605, '1531-04-01');
insert into fauna(name, avg_age, discovery_date) values ('fish_whale', 24600, '1817-10-23');
insert into fauna(name, avg_age, discovery_date) values ('perch_fish', 6205, '1631-09-28');
insert into fauna(name, avg_age, discovery_date) values ('dog', 7300, '1835-11-08');
insert into fauna(name, avg_age, discovery_date) values ('elephant', 25550, '1935-09-25');
insert into fauna(name, avg_age, discovery_date) values ('hippopotamus', 14600, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
