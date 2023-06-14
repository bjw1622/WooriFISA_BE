create database engine_trx_test;

use engine_trx_test;

create table myisam_table(
    id int not null, primary key(id)
)engine=MyISAM;

-- 더미데이터 삽입
INSERT INTO myisam_table (id) VALUES (3);

-- InnoDB 엔진 기반 테이블 생성
CREATE TABLE innodb_table ( id INT NOT NULL, PRIMARY KEY(id))
ENGINE=INNODB;

-- 더미데이터 삽입
INSERT INTO innodb_table (id) VALUES (3);

INSERT INTO innodb_table (id) values (1),(2),(3);