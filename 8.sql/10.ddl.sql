-- Data Definition Language
-- 데이터 정의어, CREATE, DROP, ALTER

use sakila;
desc film_actor;

-- 테이블 생성(create 명령어 사용)
-- DB 생성할 때는 (CREATE DATABASE~)
-- CREATE TABLE 테이블명 (필드, 타입, 제약조건 기술하는 부분)

-- 연습용 DB 생성
create database testdb;

select database();

use testdb;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	CONSTRAINT pk_person PRIMARY KEY (person_id) -- 기본키로 사용하곘다는 제약조건 명시
  -- CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)
);

#  기본키를 추가하지 않아서 테이블 제거(DROP TABBLE)
DROP TABLE person;

show tables;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	constraint pk_person primary key (person_id)
);
-- 제약조건 pk_person은 기본키로 person_id를 지정하겠다는 의미
-- CONSTRAINT 제약조건이름 조건 키워드 (조건을 적용할 컬럼명)

desc person;


CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	constraint pk_person primary key (person_id)
);

-- Person이 좋아하는 음식을 담고 있는 테이블 생성
CREATE TABLE favorite_food(
    person_id smallint,
    food varchar(20), -- food: 음식이름
    constraint pk_favorite_food PRIMARY KEY (person_id, food)
);

DESC favorite_food;

SHOW CREATE TABLE favorite_food;

drop table favorite_food;
-- favortiate_food 테이블에서 person_id를 외래키(FOREIGN KEY)로 추가하는 것을 잊었을 때

alter TABLE favorite_food add constraint  fk_favoriate_food_person_id
foreign key (person_id) --  favorite_food 테이블에 있는 person_id 컬럼을 외래키로
references person (person_id); -- 그 외래키는 person 테이블의 person_id를 참조한다

-- 테이블에 데이터 삽입(INSERT)
-- INSERT INTO 테이블명 (컬러명,...) VALUES (실제 값, ...);

INSERT INTO person (person_id, first_name, last_name)
values (1,'Kim','Seungyeon');

alter table person modify column person_id SMALLINT unsigned;

-- person_id 컬럼은 정수 타입의 기본키이기 때문에, 1씩 증가하도록해서 고유성을 보장하도록 설정 변경
# ALTER TABLE person MODIFY person_id  smallint auto_increment;
-- -> person 테이블의 person_id 컬럼 필드를 변경(데이터 INSERT 시 자동 증가하도록 설정 적용)

-- 외래키 제약조건 비활성화
set foreign_key_checks = 0; -- 비활성화
alter table person modify person_id smallint unsigned auto_increment;
set foreign_key_checks = 1;

-- 다시 INSERT
INSERT INTO person ( first_name, last_name)
values ('Kim','Seungyeon');

INSERT INTO person ( first_name, last_name)
values ('Im','Yeji');

select * from person; -- person_id 컬럼의 값이 자동 증가하여 적용됨(AUTO_INCREMENT)

INSERT INTO person(first_name, last_name, eye_color, birth_date, street)
values('STERINE','LEE','BR','1999-05-02','어쩌라고');
-- Column  count does not match value at row 1


# create database mytest;
#
# select database();
#
# use mytest;