create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(name) values ('Scoda body');
insert into body(name) values ('Lada body');
insert into body(name) values ('VW body');
insert into body(name) values ('Renault body');

insert into engine(name) values ('1.6');
insert into engine(name) values ('1.4T');
insert into engine(name) values ('2.0');
insert into engine(name) values ('2.2');

insert into transmission(name) values ('МКПП');
insert into transmission(name) values ('АКПП');

insert into car(name, body_id, engine_id, transmission_id) values ('Scoda Rapid', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Scoda Octavia', 1, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Lada Kalina', 2, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Lada Priora', 2, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('VW Polo', 3, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('VW Tiguan', 3, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Renault Logan', 4, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Renault Megane', 4, 3, 2);

select c.name, b.name, e.name, t.name from car c
join body b on body_id = b.id
join engine e on engine_id = e.id
join transmission t on transmission_id = t.id;

