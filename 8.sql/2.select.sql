show databases ;
use sakila;

select * from language;

SELECT language_id, name, last_update from language;

select language_id as '언어ID' from language;
select name as '언어명' from language;
select last_update as '마지막 업데이트' from language;

-- film _category 테이블에서 category가 Sci-Fi인 film만 조회
show tables;

select * from category;

-- WHERE는 조건식
select * from film_category where category_id=14 ;