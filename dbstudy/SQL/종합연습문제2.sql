drop table orders;
drop table customers;
drop table books;

-- 1. 다음 설명을 읽고 적절한 테이블을 생성하되, 기본키/외래키는 별도로 설정하지 마시오.

-- 1) BOOKS 테이블
--    (1) BOOK_ID : 책 아이디, 숫자 (최대 11자리), 필수
--    (2) BOOK_NAME : 책 이름, 가변 길이 문자 (최대 100)
--    (3) PUBLISHER : 출판사, 가변 길이 문자 (최대 50)
--    (4) PRICE : 가격, 숫자 (최대 6자리)
create table books (
    book_id number(11) not null,
    book_name varchar2(100),
    publisher varchar2(50),
    price number(6)
);

-- 2) CUSTOMERS 테이블
--    (1) CUST_ID : 고객 아이디, 숫자 (최대 11자리), 필수
--    (2) CUST_NAME : 고객 이름, 가변 길이 문자 (최대 20)
--    (3) ADDRESS : 고객 주소, 가변 길이 문자 (최대 50)
--    (4) PHONE : 고객 전화, 고정 길이 문자 (최대 20)
create table customers (
    cust_id number(11) not null,
    cust_name varchar2(20),
    address varchar2(50),
    phone char(20)
);

-- 3) ORDERS 테이블
--    (1) ORDER_ID : 주문 아이디, 숫자 (최대 11자리), 필수
--    (2) CUST_ID : 고객 아이디, 숫자 (최대 11자리)
--    (3) BOOK_ID : 책 아이디, 숫자 (최대 11자리)
--    (4) SALE_PRICE : 판매 가격, 숫자 (최대 6자리)
--    (5) ORDER_DATE : 주문일, 날짜
create table orders (
    order_id number(11) not null,
    cust_id number(11),
    book_id number(11),
    sale_price number(6),
    order_date date
);
-- 4) 아래 INSERT 문은 변경 없이 그대로 사용한다.
INSERT ALL
    INTO BOOKS VALUES (1, '축구의역사', '굿스포츠', 7000)
    INTO BOOKS VALUES (2, '축구아는 여자', '나무수', 13000)
    INTO BOOKS VALUES (3, '축구의 이해', '대한미디어', 22000)
    INTO BOOKS VALUES (4, '골프 바이블', '대한미디어', 35000)
    INTO BOOKS VALUES (5, '피겨 교본', '굿스포츠', 6000)
    INTO BOOKS VALUES (6, '역도 단계별 기술', '굿스포츠', 6000)
    INTO BOOKS VALUES (7, '야구의 추억', '이상미디어', 20000)
    INTO BOOKS VALUES (8, '야구를 부탁해', '이상미디어', 13000)
    INTO BOOKS VALUES (9, '올림픽 이야기', '삼성당', 7500)
    INTO BOOKS VALUES (10,'올림픽 챔피언', '피어슨', 13000)
SELECT * FROM DUAL;

INSERT ALL
    INTO CUSTOMERS VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001')
    INTO CUSTOMERS VALUES (2, '김연아', '대한민국 서울', '000-6000-0001')
    INTO CUSTOMERS VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001')
    INTO CUSTOMERS VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001')
    INTO CUSTOMERS VALUES (5, '박세리', '대한민국 대전', NULL)
SELECT * FROM DUAL;

INSERT ALL 
    INTO ORDERS VALUES (1, 1, 1, 6000, '2014-07-01')
    INTO ORDERS VALUES (2, 1, 3, 21000, '2014-07-03')
    INTO ORDERS VALUES (3, 2, 5, 8000, '2014-07-03')
    INTO ORDERS VALUES (4, 3, 6, 6000, '2014-07-04')
    INTO ORDERS VALUES (5, 4, 7, 20000, '2014-07-05')
    INTO ORDERS VALUES (6, 1, 2, 12000, '2014-07-07')
    INTO ORDERS VALUES (7, 4, 8, 13000, '2014-07-07')
    INTO ORDERS VALUES (8, 3, 10, 12000, '2014-07-08')
    INTO ORDERS VALUES (9, 2, 10, 7000, '2014-07-09')
    INTO ORDERS VALUES (10, 3, 8, 13000, '2014-07-10')
SELECT * FROM DUAL;


-- 2. BOOKS, CUSTOMERS, ORDERS 테이블들의 적절한 칼럼에 기본키를 추가하시오.
-- '테이블명_PK' 형식의 제약 조건 이름도 함께 부여하시오.
alter table books add constraint books_pk primary key (book_id);
alter table customers add constraint customers_pk primary key (cust_id);
alter table orders add constraint orders_pk primary key (order_id);

-- 3. 외래키가 필요한 테이블을 선정하고 적절한 칼럼에 외래키를 추가하시오.
-- '테이블명_참조하는테이블명_FK' 형식의 제약 조건 이름도 함께 부여하시오.
alter table orders add constraint orders_customers_fk foreign key(cust_id)
references customers(cust_id);
alter table orders add constraint orders_books_fk foreign key(book_id)
references books(book_id);

-- 4. 2014년 7월 4일부터 7월 7일 사이에 주문 받은 도서를 제외하고 나머지 모든 주문 정보를 조회하시오.
select
    *
from
    orders
where
    order_date < '14-07-04'
    or order_date > '14-07-07';

-- 5. 박지성의 총 구매액(SALE_PRICE)을 조회하시오.
select
    sum(o.sale_price)
from
    customers c
join
    orders o on c.cust_id = o.cust_id
where
    c.cust_name = '박지성';

-- 6. 박지성이 구매한 도서의 수를 조회하시오.
select
    count(*)
from
    customers c
join
    orders o on c.cust_id = o.cust_id
where
    c.cust_name = '박지성';

-- 7. 박지성이 구매한 도서를 발간한 출판사(PUBLISHER)의 수를 조회하시오.
select
    count(distinct(publisher))
from
    customers c
join
    orders o on c.cust_id = o.cust_id
join
    books b on o.book_id = b.book_id
where
    c.cust_name = '박지성';

-- 8. 고객별로 분류하여 각 고객의 이름과 각 고객별 총 구매액을 조회하시오.
select
    c.cust_name,
    nvl(sum(o.sale_price), 0) as 구매액
from
    customers c
left join
    orders o on c.cust_id = o.cust_id
group by
    c.cust_id, c.cust_name;

-- 9. 주문한 이력이 없는 고객의 이름을 조회하시오.
select
    c.cust_name
from
    customers c
left join
    orders o on c.cust_id = o.cust_id
where
    o.order_id is null;

-- 10. 고객별로 총 구매횟수를 조회하시오.
-- 구매한 이력이 없는 고객은 구매횟수를 0으로 표시하시오.
select
    c.cust_name,
    count(o.order_id) as 구매횟수
from
    customers c
left join
    orders o on c.cust_id = o.cust_id
group by
    c.cust_id, c.cust_name;
