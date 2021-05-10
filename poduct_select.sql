select * from product as p where p.type_id = 1;
select * from product as p where p.name like '%мороженое%';
select * from product as p where p.expired_date <= current_date + interval'1 month';
select * from product where price = (select max(price) from product);
select t.name, count(type_id) from product join type as t on type_id = t.id group by t.name;
select * from product where type_id = 1 or type_id = 2;
select t.name, count(type_id) from product join type as t on type_id = t.id group by t.name having count(type_id) < 10;