-- 1. 모든 사원의 last_name, salary, 본인이 근무하는 부서의 평균연봉(salary)을 조회하시오
select
    e.last_name,
    e.salary,
    (select round(avg(salary), 2) from employees where department_id = e.department_id) as 평균연봉
from
    employees e;
    
select
    e.last_name,
    e.salary,
    (select round(avg(salary), 2) from employees where department_id = e.department_id) as 평균연봉
from
    employees e;
    
-- 2. 부서별로 department_id, department_name, 평균연봉을 조회하시오
select
    d.department_id,
    d.department_name,
    (select round(avg(salary), 2) from employees where department_id = d.department_id) as 평균연봉
from
    departments d;
    
-- 3. 모든 사원들의 employee_id, last_name, department_name을 조회하시오.
select
    e.employee_id,
    e.last_name,
    (select department_name from departments where department_id = e.department_id) as 부서이름
from
    employees e;
    
-- 4. 평균연봉 이상의 연봉을 받는 사원들의 정보를 조회하시오.
select
    *
from
    employees
where
    salary >= (select avg(salary) from employees);
    
-- 5. Patrick Sully 와 같은 부서에 근무하는 모든 사원정보를 조회하시오
select
    *
from
    employees
where
    department_id = (select department_id from employees where first_name = 'Patrick' and last_name = 'Sully');
    
-- 6. 부서번호가 20인 사원들 중에서 평균연봉 이상의 연봉을 받는 사원정보를 조회하시오.
select
    *
from
    employees
where
    salary >= (select avg(salary) from employees)
    and department_id = 20;
    
-- 7. 'PU_MAN'의 최대연봉보다 더 많은 연봉을 받은 사원들의 정보를 조회하시오.
select
    *
from
    employees
where
    salary >= (select max_salary from jobs where job_id = 'PU_MAN');
    
select
    *
from
    employees e
join
    (select max_salary from jobs where job_id = 'PU_MAN') e2 on 1 = 1
where
    e.salary >= e2.max_salary;
    
-- 8. 사원번호가 131인 사원의 job_id와 salary가 모두 일치하는 사원들의 정보를 조회하시오.
select
    *
from
    employees
where
    concat(job_id, salary) = (select concat(job_id, salary) from employees where employee_id = 131);
-- 9. location_id가 1000~1900인 국가들의 country_id와 country_name을 조회하시오
select
    country_id, country_name
from
    countries
where
    country_id in (select distinct(country_id) from locations where location_id between 1000 and 1900);
    
select
    c.country_id, c.country_name
from
    countries c
join
    (select distinct(country_id) from locations where location_id between 1000 and 1900) c2 on c.country_id = c2.country_id;

-- 10. 부서가 'Executive'인 모든 사원들의 정보를 조회하시오.
-- 서브쿼리의 departmnet_name은 PK, UQ가 아니므로 서브쿼리의 결과는 여러 개이다.
select
    *
from
    employees
where
    department_id in (select department_id from departments where department_name = 'Executive');
    
-- 11. 부서번호가 30인 사원들 중에서 부서번호가 50인 사원들의 최대연봉보다 더 많은 연봉을 받는 사원들을 조회하시오.
select
    *
from
    employees
where
    salary >= (select max(salary) from employees where department_id = 50)
    and department_id = 30;
    
-- 12. manager가 아닌 사원들의 정보를 조회하시오
select
    *
from
    employees
where
    employee_id not in(select distinct manager_id from employees where manager_id is not null);
    
select
    *
from
    employees e
where
    not exists(select m.manager_id from employees m where e.employee_id = m.manager_id);
    
-- 근무지가 'Southlake' 인 사원들의 정보를 조회하시오.
select
    *
from
    employees e
where
    e.department_id = (select d.department_id from departments d where d.location_id = (select location_id from locations where city = 'Southlake'));

select
    *
from
    employees e
where
    (select d.location_id from departments d where d.department_id = e.department_id) =
    (select l.location_id from locations l where l.city = 'Southlake');
    
select
    e.*
from
    employees e
join
    departments d on e.department_id = d.department_id
join
    locations l on d.location_id = l.location_id
where
    l.city = 'Southlake';
    
-- 14. 부서명의 가나다순으로 모든 사원의 정보를 조회하시오
select
    *
from
    employees e
order by
    (select department_name from departments d where e.department_id = d.department_id), e.employee_id;

select
    *
from
    employees e
join
    departments d on e.department_id = d.department_id
order by
    d.department_name, e.employee_id;
    
-- 15. 가장 많은 사원들이 근무하고 있는 부서의 번호와 근무하는 인원수를 조회하시오
select
    department_id, count(*)
from
    employees
group by
    department_id
having
    count(*) = (select max(count(*)) from employees group by department_id);