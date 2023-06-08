-- 3.where 명으로 파일 저장
-- SELECT, FROM, WHERE, JOIN, HAVING, GROUP BY, ORDER BY..

-- WHERE는 "필터링이다"
-- customer 테이블에서 first_name이 KAREN인 회원의 모든 열 데이터 조회
SELECT * FROM customer WHERE first_name = 'KAREN';

-- actor 테이블에서 first_name이 NICK인 회원의 first_name과 last_name 조회
SELECT first_name AS fn, last_name FROM actor WHERE fn = 'NICK';
-- WHERE절은 SELECT 수행 전에 먼저 판단되기 때문에 WHERE를 평가하는 시점에는 fn이 아직 존재하지 않음

-- 컬럼의 별칭은 summary
-- 데이터 내용(record)은 '인어 공주(title 열)'의 줄거리, concatenation(문자열 접합) 내장함수
SELECT concat(title, '의 줄거리: ', description) AS summary FROM film;

-- 무작위 행 데이터(Record) 반환(MySQL Syntax) , rand()라는 내장함수
SELECT * FROM actor ORDER BY rand();

-- customer 테이블에서 first_name이 “VIRGINIA”이고 last_name이 “BLUE”인 회원의 모든 열 조회
-- 이고(AND), 이거나(OR)
SELECT *
FROM customer
WHERE first_name = 'VIRGINIA' AND last_name = 'GREEN';

-- film_category 테이블에서 category가 Animation이거나 Games인 모든 열 조회
SELECT *
FROM film_category
WHERE category_id = 2 OR category_id = 10;

-- customer 테이블에서 (first_name이 ‘STEVEN’이거나 last_name이 ‘YOUNG’) 이고,
-- create_date가 2006년 1월 1일 이후인 회원 조회
SELECT *
FROM customer
WHERE (first_name = 'STEVEN' OR last_name = 'YOUNG') and create_date >= '2006-01-01';

-- WHERE 절 뒤에 작성할 수 있는 건 조건식(Condition)
-- 조건식에 사용될 수 있는 연산자의 종류
-- =, !=, >, <, >=, LIKE, IN

-- category 테이블에서 name이 Family가 아닌 모든 카테고리 조회
SELECT * FROM category WHERE name != 'Family';
SELECT * FROM category WHERE name <> 'Family'; -- <>, !=와 같음

-- 범위 조건(Range Condition)
-- rental 테이블에서 rental_date가 2005-05-25 이전에 빌려간 회원의 id와 대여 날짜를 조회
SELECT customer_id, rental_date
FROM rental
WHERE rental_date <= '2005-05-25';

-- rental 테이블에서 rental_date가 2005-05-24부터 2005-05-25 사이의 rental_date 열 조회
SELECT * FROM rental WHERE rental_date >= '2005-05-24' AND rental_date <= '2005-05-25';

SELECT * FROM rental WHERE rental_date BETWEEN '2005-05-24' AND '2005-05-25';

-- 날짜를 반대로?
SELECT * FROM rental WHERE rental_date BETWEEN '2005-05-25' AND '2005-05-24';

-- rental 테이블에서 rental_date가 2005-05-24 23시 정각부터
-- 2005-05-24 자정까지 1시간 동안의 rental_date 열 조회
SELECT rental_date
FROM rental
WHERE rental_date BETWEEN '2005-05-24 23:00:00' AND '2005-05-25';

-- rental 테이블에서 rental_date가 2005-05-25 자정부터
-- 2005-05-25 오전 1시까지 1시간 동안의 rental_date 열 조회
SELECT rental_date
FROM rental
WHERE rental_date BETWEEN '2005-05-25' AND '2005-05-25 01:00:00';

-- payment table에서 amount가 10.0부터 10.99 사이의 모든 payment 조회
-- 숫자값은 '' Single quote, 홑 따옴표 없이 쿼리 작성 가능
SELECT * FROM payment WHERE amount BETWEEN 10.0 AND 10.99;

-- NULL, 정해지지 않은 값, 알려지지 않은 값 등을 나타낼 때 사용

-- Null의 특징 1. null과 null이 서로 같을 수 없음

-- rental 테이블에서 customer_id가 155번인 대여기록 중
-- rental_id, customer_id, return_date 열만 조회
SELECT rental_id, customer_id, return_date
FROM rental
WHERE customer_id = 155;

-- rental 테이블에서 영화(film)를 반납하지 않은 대여기록 중
-- rental_id, customer_id, return_date 조회
SELECT rental_id, customer_id, return_date
FROM rental
WHERE return_date = NULL;
-- 실제 return_date 컬럼의 값이 NULL로 할당된 행을 우항의 NULL과 비교를 하게 되는데,
-- NULL = NULL에 대한 비교가 성립이 안되기 때문에 비어있는 결과(Empty set)가 조회됨
-- 반납하지 않은 고객의 데이터가 없다는 의미가 아님

SELECT rental_id, customer_id, return_date
FROM rental
WHERE return_date IS NULL; -- NULL 비교 시에는 IS 연산자 사용

-- rental 테이블에서 영화를 반납한 대여기록 중 rental_id, customer_id, return_date를
-- 상위 50개만 조회(LIMIT 50)
SELECT rental_id, customer_id, return_date
FROM rental
WHERE return_date IS NOT NULL LIMIT 50;

-- rental 테이블에서 2005년 5월에서 8월 사이에 반납되지 않은 대여기록 중
-- rental_id, customer_id, return_date를 조회
SELECT rental_id, customer_id, return_date
FROM rental
WHERE return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';


-- NULL까지 포함하기 위해서는 별도의 조건
SELECT rental_id, customer_id, return_date
FROM rental
WHERE return_date IS NULL
OR
return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';

# 와일드 카드(LIKE)
# 쿼리의 성능에는 그렇게 좋지 않음
select *  from customer where first_name='KAREN';

select last_name,first_name from customer where last_name LIKE '_A_T%S';

select last_name,first_name from customer where last_name LIKE 'Q%' or  last_name LIKE 'Y%';