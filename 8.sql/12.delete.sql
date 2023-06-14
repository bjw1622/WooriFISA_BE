-- 12.delete.sql
-- DELETE : 테이블 내 데이터만 제거, DROP: 테이블 자체를 통쨰로 제거

-- DML(Data Manipulation) - SELECT, INSERT, UPDATE, DELETE
-- DDL(Data Definition) - CREATE, DEOP, ALTER

-- DELETE FROM 테이블명
DELETE FROM person;


INSERT INTO person(first_name, last_name, eye_color, birth_date, street)
values('STERINE','LEE','BR','1999-05-02','어쩌라고');

select * from person;
delete from person;

alter table favorite_food drop foreign key fk_favoriate_food_person_id;

-- 부모 테이블의 데이터 삭제 시 자식 테이블의 데이터도 같이 제거되도록 CASCADE 속성
alter table favorite_food add constraint foreign key (person_id) references person(person_id) on delete cascade;
-- 부모 테이블 데이터 제거 시 자식 테이블의 엮인 데이터도 같이 제거

delete from person;
-- 별도의 where 키워드를 작성하지 않으면 전체 행이 제거 됨