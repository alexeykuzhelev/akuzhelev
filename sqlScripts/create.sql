create table role (
	id serial primary key,
	role_name varchar(128)
);

create table users (
    id serial primary key,
    user_name varchar(256),
    role_id int references role(id)
);

create table rules (
	id serial primary key,
	rule_desc text
);

create table role_rules (
    id serial primary key,
	role_id int references role(id),
	rule_id int references rules(id)
);

create table state (
	id serial primary key,
	state_name varchar(128)
);

create table category (
	id serial primary key,
	cat_name varchar(128)
);

create table item (
	id serial primary key,
	item_name varchar(256),
	item_desc text,
	user_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table attachs (
	id serial primary key,
	file_name varchar(256),
	item_id int references item(id) unique
);

create table comments (
	id serial primary key,
	comment_name varchar(256),
	comment_text text,
	item_id int references item(id) unique
);
