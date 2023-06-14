select * from customer;

select max(customer_id) from customer;

select customer_id , last_name, first_name from customer where customer_id=(select max(customer_id) from customer);

-- 서브 쿼리를 활용하여 동적으로 적용될 수 있도록(customer_id가 최댓값인 회원)
-- customer_id가 최대값 => 신규 가입자



select *  from city limit 10;

select * from  country limit 10;

select city_id ,city from city where country_id = (select country_id from country where country='South Korea');

-- country 테이블에서 인도가 아닌 국가의 모근 열 조회
select * from country;

select * from country where country !=  'India';

select *  from city;
-- IN은 특정 집합에 속하는지 확인할 때 사용하는 연산자
select city_id, city from city where country_id != (select country_id from country where country='India');

select * from city;

select city_id, city from city in;

select  city_id, city from city where country_id IN(select country_id from country where country in('Canada','Mexico'));

select city_id, city from city where country_id not in (select country_id from country where country in ('Canada','Mexico'));