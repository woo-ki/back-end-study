-- 내부 조인 리뷰
-- department와 employee에 모두 존재하는 데이터
select
    e.emp_no, e.name, d.dept_name, d.location
from
    department d
join
    employee e on d.dept_no = e.department;
    
-- 외부조인
-- 1. left outer join: 왼쪽 테이블의 정보는 모두 포함, 오른쪽 테이블의 정보는 일치하는 정보만 포함
-- 2. right outer join: 오른쪽 테이블의 정보는 모두 포함, 왼쪽 테이블의 정보는 일치하는 정보만 포함
insert into employee
values (1005, '김미나', '사원', 'F', 2500000, sysdate, null);

-- 모든 직원의 사원번호, 이름, 부서명을 조회하시오
select
    e.emp_no, e.name, d.dept_name
from
    department d
right join
    employee e on d.dept_no = e.department;
    
select
    e.emp_no, e.name, d.dept_name
from
    department d, employee e
where
    d.dept_no(+) = e.department;    -- 오른쪽 외부 조인: 반대(왼쪽) 방향에 (+)를 추가한다.