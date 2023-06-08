show databases ;
use sakila;

show tables; -- sakila DB 내부에 생성된 모든 테이블 조회

DESC actor; -- actor 테이블의 정보 조회

SELECT * FROM customer; -- customer 테이블 데이터 조회

SELECT VERSION() as '버전', user(), database(); -- 현재 접속 중인 MYSQL의 버전, user, database 확인

