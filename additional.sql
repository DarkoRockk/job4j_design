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
	status varchar(255)
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

insert into user_meeting(user_id, meeting_id, status) values (1, 1, 'pending');
insert into user_meeting(user_id, meeting_id, status) values (1, 2, 'refused');
insert into user_meeting(user_id, meeting_id, status) values (2, 3, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (2, 4, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (3, 1, 'pending');
insert into user_meeting(user_id, meeting_id, status) values (3, 4, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (4, 5, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (4, 2, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (5, 3, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (5, 5, 'refused');
insert into user_meeting(user_id, meeting_id, status) values (3, 5, 'accepted');
insert into user_meeting(user_id, meeting_id, status) values (4, 1, 'pending');

select m.name, count(um.status) from meetings m
join user_meeting um on m.id = um.meeting_id
where um.status = 'accepted'
group by m.name;

select m.name, count(um.status) from meetings m
left join user_meeting um on m.id = um.meeting_id
group by m.name
having count(um.status) = 0 or
       count(um.status) = (
        select count(*) from meetings join user_meeting on meetings.id =
        user_meeting.meeting_id where meetings.name = m.name
        and user_meeting.status = 'refused'
        );

