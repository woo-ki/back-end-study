-- '구창민'과 직급이 같은 직원들의 목록을 출력하시오.
select
    *
from
    employee
where
    position IN (select position from employee where name = '구창민'); -- name 칼럼이 PK나 UQ가 아니므로 만족하는 뎅치터가 2개 이상일 수 있다.(다중 행 서브쿼리는 IN 연산자를 사용한다)
    
-- 부서번호가 1인 부서에 근무하는 모든 직급과 동일한 직급을 가지는 직원을 조회하시오.
select
    *
from
    employee
where
    position in (select position from employee where department = 1);
    
-- 가장 높은 기본급을 가지고 있는 직원과 가장 낮은 기본급을 가지고 있는 직원을 조회하시오
-- 같은 기본급간 처리는 하지 않는다.
select
    *
from
    employee
where
    salary in ((select max(salary) from employee), (select min(salary) from employee));



-- dual 테이블
-- 테이블 내부에 데이터를 저장하는 목적이 아니다.
-- from절에 작성할 테이블이 없는 경우(from절이 필요없는 경우)에 dual 테이블을 사용한다.
-- oracle은 from절이 필수이기 떄문에 뭐라도 적어줘야 해서

-- 총 몇명의 직원이 있고, 총 몇개의 부서가 있는지 조회하시오
-- 결과
-- 총직원, 총부서
--   5     4
select
    (select count(*) from employee) as 총직원,
    (select count(*) from department) as 총부서
from
    dual;
    
-- 전체 기본급에서 자신의 기본급이 몇 % 차지하는지 조회하시오.
-- 자신의 기본급 / 전체 기본급
select
    round(salary / (select sum(salary) from employee), 2) as 급여지분
from
    employee;