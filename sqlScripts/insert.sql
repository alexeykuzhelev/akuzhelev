-- insert data to role
insert into role(role_name) values ('role-1');
insert into role(role_name) values ('role-2');

-- insert data to rules
insert into rules(rule_desc) values ('rule-1');
insert into rules(rule_desc) values ('rule-2');

-- insert data to role_rules
insert into role_rules(role_id, rule_id) values (1, 1);
insert into role_rules(role_id, rule_id) values (1, 2);
insert into role_rules(role_id, rule_id) values (2, 2);

-- insert data to users
insert into users(user_name, role_id) values ('Ivan', 1);
insert into users(user_name, role_id) values ('Petr', 2);

-- insert data to state
insert into state(state_name) values ('state_name-1');
insert into state(state_name) values ('state_name-2');

-- insert data to category
insert into category(cat_name) values ('category-1');
insert into category(cat_name) values ('category-2');

-- insert data to item
insert into item(item_name, item_desc, user_id, category_id, state_id) values ('item_name-1', 'first_item', 1, 1, 1);
insert into item(item_name, item_desc, user_id, category_id, state_id) values ('item_name-2', 'second_item', 2, 1, 2);

-- insert data to attachs
insert into attachs(file_name, item_id) values ('file_name-1', 1 );
insert into attachs(file_name, item_id) values ('file_name-2', 2 );

-- insert data to comments
insert into comments(comment_name, comment_text, item_id) values ('comment_name-1', 'comment_text-1', 1);
insert into comments(comment_name, comment_text, item_id) values ('comment_name-2', 'comment_text-2', 2);
