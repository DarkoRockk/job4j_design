select
	c.name as Комп, p.name as Проц
from
	computer as c join processor as p on c.processor_id = p.id;

select
	c.name as Комп, p.name as Проц
from
	computer as c join processor as p on c.processor_id = p.id
where
	p.name like 'A%';

select
	c.name as Комп, p.name as Проц
from
	computer as c join processor as p on c.processor_id = p.id
where
	c.processor_id = 1;