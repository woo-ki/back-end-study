drop table employee;
drop table department;

create table department (
    dept_no number primary key,
    dept_name varchar2(15) not null,
    location varchar2(15) not null
);
create table employee (
    emp_no number primary key,
    name varchar2(15) not null,
    position varchar2(15),
    gender varchar2(5),
    salary number,
    hire_date date,
    department number references department(dept_no)
);

insert into department(dept_no, dept_name, location) values (1, '영업부', '대구');
insert into department(dept_no, dept_name, location) values (2, '인사부', '서울');
insert into department(dept_no, dept_name, location) values (3, '총무부', '대구');
insert into department(dept_no, dept_name, location) values (4, '기획부', '서울');

insert into employee values (1001, '구창민', '과장', 'M', 5000000, '95/05/01', 1);
insert into employee values (1002, '김민서', '사원', 'M', 2500000, '17/09/01', 1);
insert into employee values (1003, '이은영', '부장', 'F', 5500000, '90/09/01', 2);
insert into employee values (1004, '한성일', '과장', 'M', 5000000, '93/04/01', 2);

update department set location = '부산' where dept_name = '총무부';
update employee set salary = salary * 1.05 where position = '사원';
update employee set position = '차장', salary = salary * 1.1 where position = '과장';

delete from department where dept_name = '기획부';