-- select 검색할 칼럼
-- from 테이블
-- [where 조건식]
-- [group by 그룹할 칼럼][having 조건식]
-- [order by 정렬기준]

-- 1. 카테진 곱
-- 1) 두 테이블의 모든 조합이 나타나는 조인
-- 2) 조인조건을 잘못 세운 경우에 주로 발생
select
    *
from
    employee, department;
    
select
    *
from
    employee
cross join
    department;
    
-- 2. 내부조인
-- 1) 두 테이블에 모두 존재하는 데이터만 조인
-- 2) 방식
--  (1) select 칼럼 from 테이블1, 테이블2 where 테이블1.칼럼 = 테이블2.칼럼;
--  (2) select 칼럼 from 테이블1 join 테이블2 on 테이블1.칼럼 = 테이블2.칼럼;
-- 2-1 모든 사원들의 name과 dept_name을 조회하시오
select
    e.name, d.dept_name
from
    employee e
join
    department d on e.department = d.dept_no;
    
-- 2-2 서울에서 근무하는 직원들의 사원번호와 이름을 조회하시오
select
    e.emp_no, e.name
from
    employee e
join
    department d on e.department = d.dept_no
where
    d.location = '서울';

create view 과장들 as
(select * from employee where position = '과장');
drop view 과장들;