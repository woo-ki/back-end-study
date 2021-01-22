-- dual 테이블
-- dummy 칼럼에 'X' 값만 가지고 있는 테이블
-- 오라클의 select 문은 반드시 from 절이 필요하므로 from dual을 통해서 테이블이 필요 없는 쿼리를 완성한다.

-- *** 문자열 ***
-- 1. 대소문자 변환 함수
select upper('apple') from dual;    -- APPLE (모두 대문자)
select lower('APPLE') from dual;    -- apple (모두 소문자)
select initcap('APPLE') from dual;  -- Apple (첫글자만 대문자 나머지는 소문자)

-- 2. 길이 구하기, 크기 구하기
select length('APPLE') from dual;   -- 5 (글자수)
select length('사과') from dual;     -- 2 (글자수)
select lengthb('APLLE') from dual;  -- 5 (바이트수)
select lengthb('사과') from dual;    -- 4 또는 6 (바이트수) - 한글은 인코딩에 따라 다르다.

-- 3. 문자열 연결하기
-- 1) 연산자: || 인수1 || 인수2
-- 2) 함수 concat(인수1, 인수2) (concatenate)
select concat(concat(first_name, ' '), last_name) from employees;

-- 4. 문자열 분리하기
-- 시작위치는 1부터 시작된다.
-- 마이너스 위치를 지원한다.
--  a  p  p  l  e
--  1  2  3  4  5
-- -5 -4 -3 -2 -1
-- substr(문자열, 시작위치) : 시작위치부터 끝까지 추출
-- substr(문자열, 시작위치, 글자수) : 시작위치부터 글자수만큼 추출
select substr('010-1234-5678', 1, 3) from dual; -- 010 (1번째 글자부터 3글자)
select substr('010-1234-5678', -4) from dual;   -- 5678 (뒤 4글자)

-- 5. 특정 문자열 위치 반환하기
-- 1) instr(검색대상, 찾을문자열)
-- 2) instr(검색대항, 찾을문자열, 시작위치, N번째)
select instr('SQLSESSION', 'S') from dual;  -- 1 ('S'가 나타난 첫 번째 위치)
select instr('SQLSESSION', 'A') from dual;  -- 0 (찾는 문자열이 없는경우)
select instr('SQLSESSION', 'S', 1, 2) from dual; -- 4 (첫번째 문자부터 검색하여 'S'가 나타난 두 번째 위치)
select instr('SQLSESSION', 'S', 1, 3) from dual; -- 6 (첫번째 문자부터 검색하여 'S'가 나타난 세 번째 위치)
select instr('SQLSESSION', 'S', 1, 4) from dual; -- 7 (첫번째 문자부터 검색하여 'S'가 나타난 네 번째 위치)

-- 6. 채우기
-- 1) LPAD(채우기대상, 폭, 채울문자) : 채우기대상의 전체 길이가 지정된 폭만큼 왼쪽이 채울문자로 채워진다.
-- 2) RPAD(채우기대상, 폭, 채울문자) : 채우기대상의 전체 길이가 지정된 폭만큼 오른쪽이 채울문자로 채워짐.
select lpad('APPLE', 10, '*') from dual;
select rpad('BANANA', 10, '*') from dual;
select add_months('19-11-01', 3) from dual;
-- 7. 좌우 불필요한 문자 제거하기
-- 1) ltrim(대상, 제거할 문자열) : 왼쪽에서 제거할 문자열을 제거, 제거할 문자열을 생략하면 공백 제거
-- 2) rtrim(대상, 제거할 문자열) : 오른쪽에서 제거할 문자열을 제거, 제거할 문자열을 생략하면 공백 제거
-- 3) trim(대상, 제거할 문자열) : 양쪽에서 제거할 문자열을 제거, 제거할 문자열을 생략하면 공백 제거
select length(ltrim('  APPLE')) from dual;  -- 5 (공백 제거하면 APPLE만 남음, APPLE의 글자수는 5)
select length(rtrim('APPLE       ')) from dual;
select length(trim('          APPLE       ')) from dual;

-- 문제1. 아이디 찾기 결과 만들기
-- amdin : ad********
-- myid : my********
-- yourid : yo********
select
    rpad(substr(last_name, 1, 2), 10, '*')
from
    employees;

-- 문제2. 성과 이름 분리하기
-- james dean
-- 홍 길동
-- 1) 성(james, 홍) 출력하기
select trim(substr('james dean', 1, instr('james dean', ' '))) from dual;
select trim(substr('홍 길동', 1, instr('홍 길동', ' '))) from dual;
-- 2) 이름 (dean, 길동) 출력하기
select trim(substr('james dean', instr('james dean', ' '))) from dual;
select trim(substr('홍 길동', instr('홍 길동', ' '))) from dual;

-- *** 숫자 ***
-- 1. 반올림
select round(123.4567, 2) from dual;    -- 123.45 (소수 2자리로 반올림)
select round(123.4567, 1) from dual;    -- 123.5  (소수 1자리로 반올림)
select round(123.4567) from dual;       -- 123    (정수로 반올림)
select round(123.4567, -1) from dual;   -- 120    (일의 자리에서 반올림)
select round(123.4567, -2) from dual;   -- 100    (십의 자리에서 반올림)

-- 2. 절사(자르기)
select trunc(123.4567, 2) from dual;    -- 123.45 (소수 2자리로 자름)
select trunc(123.4567, 1) from dual;    -- 123.4  (소수 1자리로 자름)
select trunc(123.4567) from dual;       -- 123    (정수로 자름)
select trunc(123.4567, -1) from dual;   -- 120    (일의 자리 자름)
select trunc(123.4567, -2) from dual;   -- 100    (십의 자리 자름)

-- 3. 올림
-- 123.4567 -> (*100) -> 12345.67 -> (ceil) -> 12346 -> (/100) -> 123.46
-- 123.4567 -> (*10) -> 1234.567 -> (ceil) -> 1235 -> (/10) -> 123.5
select ceil(123.4567 * 100) / 100 from dual;    -- 123.46 (소수 2자리로 올림)
select ceil(123.4567 * 10) /10 from dual;       -- 123.5  (소수 1자리로 올림)
select ceil(123.4567) from dual;                -- 124    (정수로 올림)
select ceil(123.4567 / 10) * 10 from dual;      -- 130    (1의 자리에서 올림)
select ceil(123.4567 / 100) * 100 from dual;    -- 200    (10의 자리에서 올림)

-- 4. 내림
select floor(123.4567 * 100) / 100 from dual;   -- 123.45 (소수 2자리로 내림)
select floor(123.4567 * 10) / 10 from dual;     -- 123.4  (소수 1자리로 내림)
select floor(123.4567) from dual;               -- 123    (정수로 내림)
select floor(123.4567 / 10) * 10 from dual;     -- 120    (1의 자리에서 내림)
select floor(123.4567 / 100) * 100 from dual;   -- 100    (10의 자리에서 내림)

-- 절사와 내림의 차이는 음수에서 발생한다.
-- 절사는 그대로 자르고, 내림은 작은수로 바꾼다.
select trunc(-1.5) from dual;   -- -1 (0.5를 잘라 버림)
select floor(-1.5) from dual;   -- -2 (-1.5보다 작은 정수로 변환)

-- 5. 집계함수
-- 1) sum(칼럼) : 칼럼의 합계, sum(칼럼1, 칼럼2)와 같은 방식은 지원되지 않는다. sum(칼럼1)+sum(칼럼2)와 같이 처리한다.
-- 2) avg(칼럼) : 칼럼의 평균
-- 3) max(칼럼) : 칼럼의 최대값
-- 4) min(칼럼) : 칼럼의 최소값
-- 5) count(칼럼) : 칼럼의 데이터 개수 (null 제외)
--    count(*)   : 레코드(행,row)의 개수

-- *** 날짜 ***
-- 1. 현재 날짜 반환
select sysdate from dual;

-- 2. 날짜는 숫자처럼 연산이 가능하다
-- 1일 : 1
-- 12시간 : 0.5
select sysdate + 50 from dual;

-- 3. 개월 연산은 함수로 처리한다.
select add_months(sysdate, 3) from dual; -- 3개월 후
select add_months(sysdate, -3) from dual; -- 3개월 전

-- 4. 개월 수 차이
select months_between(sysdate, sysdate - 180) from dual;

-- *** 타입 변환 ***
-- 1. 문자열 변환 : to_char
select to_char(123) from dual;   -- '123' (문자열 형식의 123)
select to_char(123, '999999') from dual;    -- '   123' (9 하나당 공백 하나)
select to_char(123, '99') from dual;    -- '###' (값보다 9가 부족하면 오류)
select to_char(1234, '9,999') from dual;    -- '1,234'
select to_char(1234, '9,999.99') from dual; -- '1,234.00'
select to_char(sysdate, 'yyyy/mm/dd day hh:mi:ss') from dual;

-- 2. 숫자로 변환
select to_number('100') from dual;  -- 100 (숫자 100)

-- 참고. 숫자와 문자열의 비교
-- 100 = '100'
-- 자동으로 숫자로 변환해서 비교를 진행한다.
-- 100 = to_number('100') 으로 변환된 뒤에 비교한다.

-- 3. 날짜로 변환
select to_date('20/10/05', 'yy/mm/dd') from dual;   -- 2020년 10월 05일
select to_date('20/10/05', 'yy/dd/mm') from dual;   -- 2020년 05월 10일
select to_date('140825', 'yymmdd') from dual;       -- 2014년 08월 25일

select to_date(sysdate, 'yyyy-mm-dd') from dual;    -- 20/10/30   날짜를 'yyyy-mm-dd'와 같은 형식으로 바꾸는 용도가 아니다.
select to_char(sysdate, 'yyyy-mm-dd') from dual;    -- 2020-10-30 날짜의 형식을 변경해서 표시하는 함수는 to_char이다.

select sysdate - '20/01/01' from dual;  -- 날짜 - 문자열은 연산이 안 된다.
select sysdate - to_date('20/01/01', 'yy/mm/dd') from dual;  -- 날짜 - 문자열은 연산이 안 된다.