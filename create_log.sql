create table pets(
	id serial primary key,
	name varchar(255),
	type text
)

insert into pets(name, type) values ('Бобик', 'собака')

select * from pets

update pets set name = 'Шарик';

select * from pets;

delete from pets;

select * from pets;
