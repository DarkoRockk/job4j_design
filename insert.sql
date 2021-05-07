insert into role(name) values ('programmer');
insert into role(name) values ('manager');
insert into category(name) values ('asap');
insert into category(name) values ('normal');
insert into state(name) values ('new');
insert into state(name) values ('in progress');
insert into state(name) values ('done');
insert into users(name, role_id) values ('Ivanov Ivan', 1);
insert into users(name, role_id) values ('Petrov Petr', 2);
insert into rules(name) values ('programming');
insert into rules(name) values ('management');
insert into role_rules(role_id, rules_id) values(1, 1);
insert into role_rules(role_id, rules_id) values(2, 2);
insert into item(name, users_id, category_id, state_id)
	values('developing of new program', 1, 2, 1);
insert into item(name, users_id, category_id, state_id)
	values('prepare financial report', 2, 1, 1);
insert into comments(name, item_id) values('additional info: google.com', 1);
insert into comments(name, item_id) values('Be quickly!!!', 2);
insert into attachs(name, item_id) values('???', 1);
insert into attachs(name, item_id) values('???', 2);