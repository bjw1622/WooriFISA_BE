-- 11. update.sql
select * from person;

-- update키워드 - 테이블 내 값을 수정할 때
-- update 테이블 명
-- set 수정할 필드명 = '수정할 값'
-- [수정할 필드명 = '수정할 값'], ...
-- [WHERE Exp]

-- bulk query
UPDATE person
SET street = 'GREEN TEA STREET', state='MA', country='USA',postal_code='231312';

-- ERROR. safe update mode를 사용 중이다

select * from person;