create table users (
	id serial primary key,
	name varchar(255)
);

create table meetings (
	id serial primary key,
	name varchar(255)
);

create table user_meeting (
	id serial primary key,
	user_id int references users(id),
	meeting_id int references meetings(id),
	status boolean
);

insert into users(name) values ('User1');
insert into users(name) values ('User2');
insert into users(name) values ('User3');
insert into users(name) values ('User4');
insert into users(name) values ('User5');

insert into meetings(name) values ('Meet1');
insert into meetings(name) values ('Meet2');
insert into meetings(name) values ('Meet3');
insert into meetings(name) values ('Meet4');
insert into meetings(name) values ('Meet5');
insert into meetings(name) values ('Meet6');

insert into user_meeting(user_id, meeting_id, status) values (1, 1, true);
insert into user_meeting(user_id, meeting_id, status) values (1, 2, false);
insert into user_meeting(user_id, meeting_id, status) values (2, 3, true);
insert into user_meeting(user_id, meeting_id, status) values (2, 4, true);
insert into user_meeting(user_id, meeting_id, status) values (3, 1, false);
insert into user_meeting(user_id, meeting_id, status) values (3, 4, true);
insert into user_meeting(user_id, meeting_id, status) values (4, 5, true);
insert into user_meeting(user_id, meeting_id, status) values (4, 2, true);
insert into user_meeting(user_id, meeting_id, status) values (5, 3, false);
insert into user_meeting(user_id, meeting_id, status) values (5, 5, false);
insert into user_meeting(user_id, meeting_id, status) values (3, 5, true);
insert into user_meeting(user_id, meeting_id, status) values (4, 1, false);
