select p.name, c.name from person p join company c on p.company_id = c.id where p.company_id <> 5;

select c.name, count(p.name) from company c join person p on p.company_id = c.id
group by c.name
order by count(p.name) desc, c.name limit 1;