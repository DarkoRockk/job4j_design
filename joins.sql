create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('Deaprtment 1');
insert into departments(name) values ('Department 2');
insert into departments(name) values ('Department 3');

insert into employees(name, department_id) values ('Employee 1', 1);
insert into employees(name, department_id) values ('Employee 2', 3);
insert into employees(name, department_id) values ('Employee 3', 3);
insert into employees(name, department_id) values ('Employee 4', null);
insert into employees(name, department_id) values ('Employee 5', null);
insert into employees(name, department_id) values ('Employee 6', 1);

-- Выполнить запросы с left, rigth, full, cross соединениями
select * from departments d left join employees e on e.department_id = d.id;
select * from departments d right join employees e on e.department_id = d.id;
select * from departments d full join employees e on e.department_id = d.id;
select * from departments cross join employees;

--  Используя left join найти департаменты, у которых нет работников
select d.name from departments d left join employees e on e.department_id = d.id where e.department_id is null;

-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
select * from departments d left join employees e on e.department_id = d.id;
select * from employees e right join departments d on e.department_id = d.id;

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Маша', 'жен');
insert into teens(name, gender) values ('Даша', 'жен');
insert into teens(name, gender) values ('Катя', 'жен');
insert into teens(name, gender) values ('Петя', 'муж');
insert into teens(name, gender) values ('Паша', 'муж');
insert into teens(name, gender) values ('Вова', 'муж');

-- Используя cross join составить все возможные разнополые пары.
select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender = 'муж' and t2.gender = 'жен';


