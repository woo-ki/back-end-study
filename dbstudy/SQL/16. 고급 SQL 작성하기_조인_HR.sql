-- 1. 부서의 위치(location_id)가 1700 인 사원들의 employee_id, last_name, department_id, salary 를 조회한다.
-- 사용할 테이블 (departments, employees)
select
    e.employee_id, e.last_name, e.department_id, e.salary
from
    employees e
join
    departments d on e.department_id = d.department_id
where
    d.location_id = 1700;
    
select
    e.employee_id, e.last_name, e.department_id, e.salary
from
    employees e, departments d
where
    e.department_id = d.department_id
    and d.location_id = 1700;

-- 2. 부서명(department_name)이 'Executive' 인 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 를 조회한다.
-- 사용할 테이블 (departments, employees)
select
    e.department_id, e.last_name, e.job_id
from
    employees e
join
    departments d on e.department_id = d.department_id
where
    d.department_name = 'Executive';
    
select
    e.department_id, e.last_name, e.job_id
from
    employees e, departments d
where
    e.department_id = d.department_id
    and d.department_name = 'Executive';
    
-- 3. 기존의 직업(job_id)을 여전히 가지고 있는 사원들의 employee_id, job_id 를 조회한다.
-- 사용할 테이블 (employees, job_history)
select
    e.employee_id, e.job_id,j.start_date, j.end_date,j.job_id
from
    employees e
left join
    job_history j on e.employee_id = j.employee_id
where
    j.employee_id is not null;

-- 4. 각 부서별 사원수와 평균연봉을 department_name, location_id 와 함께 조회한다.
-- 평균연봉은 소수점 2 자리까지 반올림하여 표현하고, 각 부서별 사원수의 오름차순으로 조회한다.
-- 사용할 테이블 (departments, employees)
select
    d.department_name, d.location_id, count(*) as 사원수, round(avg(salary), 2) as 평균연봉
from
    employees e
left join
    departments d on e.department_id = d.department_id
group by
    d.department_name, d.location_id
order by
    사원수;

-- 5. 도시이름(city)이 T 로 시작하는 지역에 사는 사원들의 employee_id, last_name, department_id, city 를 조회한다.
-- 사용할 테이블 (employees, departments, locations)
select
    e.employee_id, e.last_name, e.department_id, l.city
from
    employees e
join
    departments d on e.department_id = d.department_id
join
    locations l on d.location_id = l.location_id
where
    l.city like 'T%';
    
select
    e.employee_id, e.last_name, e.department_id, l.city
from
    employees e, departments d, locations l
where
    e.department_id = d.department_id
    and d.location_id = l.location_id
    and l.city like 'T%';


-- 6. 자신의 담당 매니저(manager_id)의 고용일(hire_date)보다 빨리 입사한 사원을 찾아서 last_name, hire_date, manager_id 를 조회한다. 
-- 사용할 테이블 (employees)
select
    e.last_name, e.hire_date, e.manager_id
from
    employees e
join
    employees e2 on e.manager_id = e2.employee_id
where
    e2.hire_date >= e.hire_date;


-- 7. 같은 소속부서(department_id)에서 나보다 늦게 입사(hire_date)하였으나 나보다 높은 연봉(salary)을 받는 사원이 존재하는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
select
    distinct e.department_id, concat(concat(e.first_name, ' '), e.last_name) as full_name, e.salary, e.hire_date
from
    employees e
join
    employees e2 on e.department_id = e2.department_id
where
    e.hire_date < e2.hire_date
    and e.salary < e2.salary
--group by
    --e.department_id, concat(concat(e.first_name, ' '), e.last_name), e.salary, e.hire_date
order by
    full_name;


-- 8. 같은 소속부서(department_id)의 다른 사원보다 늦게 입사(hire_date)하였으나 현재 더 높은 연봉(salary)을 받는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)
select
    distinct e.department_id, concat(concat(e.first_name, ' '), e.last_name) as full_name, e.salary, e.hire_date
    -- e.first_name || ' ' || e.last_name
from
    employees e
join
    employees e2 on e.department_id = e2.department_id
where
    e.hire_date < e2.hire_date
    and e.salary > e2.salary
--group by
    --e.department_id, concat(concat(e.first_name, ' '), e.last_name), e.salary, e.hire_date
order by
    full_name;
