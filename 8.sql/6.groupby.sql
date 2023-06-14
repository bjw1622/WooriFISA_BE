-- rental 테이블을 조회해서
-- 가장 대여를 많이 한 고객에게 사은품을 주어야하는데, 그러한 고객을 찾기 위한 방법
use sakila;
desc rental;

select * from rental limit 20;

# rental 테이블에서 custmoer_id를 그룹핑하여 조회
select customer_id from rental group by  customer_id;

select customer_id, count(rental_date) from rental group by customer_id order by 2;

-- 대여 횟수가 40번 미만인 데이터는 제외(필터링)

select customer_id, count(rental_date) from rental group by customer_id having count(rental_date) > 40;

desc sakila.city;
# city 테이블은 city_id,  city, county_id, last_update라는 필드를 가진다
# city 테이블에서 country id가 2인 city들의 수를 그룹핑하여 last_update가 "2006-02-15"보다 클때를 조회해라
select count(city) from  city group by city_id having country_id=2;

# fiml당 출연한 배우의 수;
select count(actor_id)  from film_actor group by film_id;

#대여 횟수를 내림차순으로 정렬
select * from rental;

# 영화 카테고리 NAME과 각 카테고리마다 몇개의 영화가 있는지 영화 개수 출력 - 진영
select * from film_category;
select * from film;

-- payment 테이블에서 고객 아이디 당 총 금액을 얼마썼는지 조회 (총 금액 100 이상만) - 종민
select * from payment;
select customer_id, sum(amount) from payment  group by customer_id having sum(amount)>100 order by sum(amount);

-- country 테이블에서 country_id 및 각 나라의 맨 앞글자로 시작하는 나라명을 count하여 별도의 열로 내림차순으로 조회한다. 그러면서 count 된 나라가 5개 이상이여야지만 조회. - 은엽
select * from country;
select left(country,1) as first_letter, count(country_id) as count_country from country group by first_letter  having count(country_id)>=5 order by count_country desc;

select p.rental_id, p.customer_id from payment as p join rental as r on p.rental_id = r.rental_id and p.customer_id = r.customer_id order by r.rental_id;


