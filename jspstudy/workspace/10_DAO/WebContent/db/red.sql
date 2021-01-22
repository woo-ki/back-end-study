drop table red;
create table red (
	no number primary key,
	id varchar2(20) not null unique,
	pw varchar2(20) not null,
	name varchar2(20),
	age number,
	email varchar2(100) not null unique,
	regdate date
);

drop sequence red_seq;
create sequence red_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;