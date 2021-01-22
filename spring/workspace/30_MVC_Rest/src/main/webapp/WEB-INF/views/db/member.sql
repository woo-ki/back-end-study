drop sequence member_seq;
drop table member;

create sequence member_seq
start with 1
increment by 1
maxvalue 999999
nocache
nocycle;

create table member (
	no number primary key,
	id varchar2(50),
	name varchar2(100),
	gender varchar2(10),
	address varchar2(200)
);

insert into member values(member_seq.nextval, 'user1', '홍길동', '남', '서울');
insert into member values(member_seq.nextval, 'user2', '김길동', '여', '인천');
insert into member values(member_seq.nextval, 'user3', '나길동', '여', '강원');
insert into member values(member_seq.nextval, 'user4', '후길동', 'unknown', '서울');
insert into member values(member_seq.nextval, 'user5', '정길동', '남', '제주');