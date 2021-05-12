select * from product as p join type t on type_id = t.id where t.name = 'сыр';
select * from product as p where p.name like '%мороженое%';
select * from product as p where date_part('month', expired_date) = date_part('month', now() + interval '1 month');
select * from product where price = (select max(price) from product);
select t.name, count(type_id) from product join type as t on type_id = t.id group by t.name;
select * from product as p join type t on type_id = t.id where t.name = 'сыр' or t.name = 'молоко';
select t.name, count(type_id) from product join type as t on type_id = t.id group by t.name having count(type_id) < 10;
select p.name, t.name from product as p join type as t on p.type_id = t.id;