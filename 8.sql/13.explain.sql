show create table actor;
use sakila;

# show table status like 'actor\g';

explain select * from film_category where film_id = 1;

explain SELECT customer_id, first_name, last_name
FROM customer
WHERE customer_id = (SELECT MAX(customer_id) FROM customer);

explain select now();

EXPLAIN SELECT * FROM rental WHERE rental_date BETWEEN '2005-05-24' AND '2005-05-25';