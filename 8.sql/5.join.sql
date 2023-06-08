desc customer;

select * from customer;

desc address;
select * from address;

select c.first_name,c.last_name, a.address from customer as c join address as a limit 5;


select c.first_name, c.last_name, a.address from customer c join address a on c.address_id = a.address_id where a.postal_code = 52137;