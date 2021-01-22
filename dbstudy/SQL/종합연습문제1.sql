drop table buys;
drop table users;
-- 사용자 테이블
-- 칼럼 : 사용자번호, 아이디, 이름, 태어난년도, 주소, 연락처1, 연락처2, 가입일
-- 기본키 : 사용자번호
-- not null : 아이디
-- unique : 아이디
create table users(
    user_no number primary key,
    user_id varchar2(20) not null unique,
    user_name varchar2(20),
    user_year NUMBER(4),
    user_addr varchar2(100),
    user_mobile1 varchar2(3), -- 010 011 017
    user_mobile2 varchar2(8), -- 45454444 12448484
    user_regdate date
);

-- 구매 테이블
-- 칼럼 : 구매번호, 아이디, 제품명, 제품카테고리, 제품가격, 구매개수
-- 기본키 : 구매번호
-- not null : 없음
-- unique : 없음
-- 외래키 : 아이디 (사용자 테이블의 아이디 칼럼을 참조하는 키)
create table buys(
    buy_no number primary key,
    user_id varchar2(20) references users(user_id),
    prod_name varchar2(20),
    prod_category varchar2(20),
    prod_price number,
    buy_amount number
);

-- users 테이블 레코드(행, row)
insert into users values (1, 'YJS', '유재석', 1972, '서울', '010', '11111111', '08/08/08');
insert into users values (2, 'KHD', '강호동', 1970, '경북', '011', '22222222', '07/07/07');
insert into users values (3, 'KKJ', '김국진', 1965, '서울', '019', '33333333', '08/09/09');
insert into users values (4, 'KYM', '김용만', 1967, '서울', '010', '44444444', '15/05/05');
insert into users values (5, 'KJD', '김제동', 1974, '경남', null, null, '13/03/03');
insert into users values (6, 'NHS', '남희석', 1971, '충남', '016', '55555555', '14/04/04');
insert into users values (7, 'SDY', '신동엽', 1971, '경기', null, null, '08/10/10');
insert into users values (8, 'LHJ', '이휘제', 1972, '경기', '011', '66666666', '06/04/04');
insert into users values (9, 'LKK', '이경규', 1960, '경남', '018', '77777777', '04/12/12');
insert into users values (10, 'PSH', '박수홍', 1970, '서울', '010', '88888888', '12/05/05');

-- buys 테이블 레코드(행, row)
insert into buys values (1001, 'KHD', '운동화', null, 30, 2);
insert into buys values (1002, 'KHD', '노트북', '전자', 1000, 1);
insert into buys values (1003, 'KYM', '모니터', '전자', 200, 1);
insert into buys values (1004, 'PSH', '모니터', '전자', 200, 5);
insert into buys values (1005, 'KHD', '청바지', '의류', 50, 3);
insert into buys values (1006, 'PSH', '메모리', '전자', 80, 10);
insert into buys values (1007, 'KJD', '책', '서적', 15, 5);
insert into buys values (1008, 'LHJ', '책', '서적', 15, 2);
insert into buys values (1009, 'LHJ', '청바지', '의류', 50, 1);
insert into buys values (1010, 'PSH', '운동화', null, 30, 2);

-- 구매 테이블에서 제품명이 '운동화'인 구매 내역의 제품 카테고리를 '신발'로 수정하시오
update buys set prod_category = '신발' where prod_name = '운동화';

-- 사용자 테이블에서 사용자 번호가 5인 사용자를 삭제하시오.
-- 사용자번호가 5인 사용자의 구매 내역을 먼저 삭제한 뒤 진행한다.
delete from buys where user_id = (select user_id from users where user_no = 5);
delete from users where user_no = 5;

-- 사용자 아이디별 구매횟수를 조회하시오
select
    b.user_id, count(*) as 구매횟수
from
    buys b
group by
    b.user_id;
    
-- 어떤 고객이 어떤 제품을 구매하였는지 조회하시오.(구매한 이력이 있는 고객만 조회하는 내부 조인)
-- 구매이력이 없는 고객도 함께 조회하시오(users 테이블의 모든 데이터를 포함하고, Buys테이블의 일치하는 데이터만 포함하는 외부조인)
-- 고객명  구매제품
-- 강호동  운동화 
-- 내부조인
select
    u.user_name,
    b.prod_name
from
    users u
join
    buys b on u.user_id = b.user_id;

-- 외부조인
select
    u.user_name,
    b.prod_name
from
    users u
left join
    buys b on u.user_id = b.user_id;
    
-- 제품을 구매한 이력이 있는 고객아이디와 고객명, 총 구매횟수를 조회하시오
select
    u.user_id,
    u.user_name,
    count(*) as 구매횟수
from
    users u
join
    buys b on u.user_id = b.user_id
group by
    u.user_id, u.user_name;

-- 제품을 구매한 이력이 있는 고객명, 총 구매액을 구하시오
select
    u.user_name,
    sum(b.prod_price * b.buy_amount) as 구매액
from
    users u
join
    buys b on u.user_id = b.user_id
group by
    u.user_id,u.user_name;

-- 구매이력과 상관 없이 고객별 구매횟수를 조회하시오
-- 구매 이력이 없으면 구매 횟수는 0으로 조회하시오
select
    u.user_name,
    count(b.buy_no) as 구매횟수
from
    users u
left join
    buys b on u.user_id = b.user_id
group by
    u.user_name;
    
-- 구매이력에 상관 없이 고객별 총 구매액을 조회하시오.
-- 구매 이력이 없으면 총 구매액은 0으로 조회하시오
select
    u.user_name,
    nvl(sum(b.prod_price * b.buy_amount), 0) as 구매액
from
    users u
left join
    buys b on u.user_id = b.user_id
group by
    u.user_id, u.user_name;
    
-- 카테고리가 '전자'인 제품을 구매한 고객명과 총 구매액을 조회하시오
select
    u.user_name,
    sum(b.prod_price * b.buy_amount) as 구매액
from
    users u
join
    buys b on u.user_id = b.user_id
where
    b.prod_category = '전자'
group by
    u.user_id, u.user_name;
    
-- 구매횟수가 2회 이상인 고객명과 구매횟수를 조회하시오.
select
    u.user_name,
    count(*) as 구매횟수
from
    users u
join
    buys b on u.user_id = b.user_id
group by
    u.user_id, u.user_name
having
    count(*) >= 2;
    
-- users 테이블과 buys 테이블 각각의 종속관계를 확인하고 정규화 하시오
-- buys 테이블을 buys 테이블과 product 테이블로 분리한다.
create table product(
    prod_code number primary key,
    prod_name varchar2(20) unique,
    prod_category varchar2(20),
    prod_price number
);

create table buys (
    buy_no number primary key,
    user_id varchar2(20) references users(user_id),
    prod_name varchar2(20) references product(prod_name),
    buy_amount number
);