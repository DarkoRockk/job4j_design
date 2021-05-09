create table processor(
	id serial primary key,
	name varchar(255)
);

create table computer(
	id serial primary key,
	name varchar(255),
	processor_id int references processor(id)
);

insert into processor(name) values ('Intel');
insert into processor(name) values ('AMD');

insert into computer(name, processor_id) values ('Mac2015', 2);
insert into computer(name, processor_id) values ('Win2021', 1);
insert into computer(name) values ('Win2020');