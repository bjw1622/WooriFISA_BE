--  Class Table
create database Class;

create table Class(
    class_id smallint,
    class_name varchar(30),
    office varchar(3),
    constraint pk_class_id primary key  (class_id)
);
select * from Class;

-- Student Table
create table Student(
    stu_id smallint,
    name varchar(10),
    age int,
    class_id  smallint,
    constraint pk_student_id primary key  (stu_id),
    constraint fk_class_id foreign key (class_id) references Class(class_id)
);
select * from student;

# auto_increment 추가
set foreign_key_checks = 0; -- 비활성화
alter table class modify class_id smallint auto_increment;
alter table student modify stu_id smallint auto_increment;

insert into class ( class_name, office)
values ('클라우드 서비스 개발','601');

insert into class ( class_name, office)
values ('클라우드 엔지니어링','602');

insert into class ( class_name, office)
values ('AI 엔지니어링','603');

insert into student ( name, age, class_id)
values ('김수현','25',1);

insert into student ( name, age, class_id)
values ('백재원','27',2);

select * from student;

select  s.name, c.class_name from class as c join student s on c.class_id = s.class_id;


