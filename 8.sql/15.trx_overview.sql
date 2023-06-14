create database trx_test;
use trx_test;

select database();

CREATE TABLE t1 (
	cd INT,
	v1 INT
);
INSERT INTO t1 VALUES (1, 50);
INSERT INTO t1 VALUES (2, 50);
commit;

select @@autocommit;

# autocomiit 비활성화
set @@autocommit = 0;

#  트랜잭션 시작, 이 아래로 작성되는 모든 쿼리는 하나의 트랜잭션  내에 포함됨
begin;
# (start transaction)
insert into t1 values(3,50);

SELECT trx_id, trx_state, trx_started, trx_operation_state, trx_tables_in_use, trx_tables_locked, trx_isolation_level FROM INFORMATION_SCHEMA.INNODB_TRX;
# 트랜잭션 종료
commit;

-- 현재 용중인 테이블의 엔진 조홰
show table status where name='t1';