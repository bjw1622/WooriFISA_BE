-- 범위에 따른 JOIN의 구분
-- INNER JOIN 조인이 성공한 범위(결과 행)만 반환하는 조인
use join_test2;
SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb'
FROM ta a
INNER JOIN tb b
ON b.x = a.x AND b.y = a.y;

SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb'
FROM ta a
INNER JOIN tb b
ON b.x = a.x AND b.y = a.y AND b.z = a.z;