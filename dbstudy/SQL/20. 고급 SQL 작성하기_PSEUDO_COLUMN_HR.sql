-- 1. 연봉이 가장 높은 사원을 조회하시오.
select
    e.*
from
    (select e.* from employees e order by salary desc) e
where
    rownum = 1;

-- 2. 연봉 top 10 조회하시오
select
    *
from
    (select * from employees order by salary desc)
where
    rownum between 1 and 10;

-- 3. 연봉 top11~20 을 조회하시오
select
    a.*
from
    (select rownum rn, a.* from (select e.* from employees e order by salary desc) a) a
where
    rn between 11 and 20;
    
select
    *
from
    employees
where
    employee_id in (select employee_id from (select rownum rn, employee_id from (select * from employees order by salary desc)) where rn between 11 and 20)
order by
    salary desc;