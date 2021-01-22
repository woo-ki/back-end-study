drop table green;
create table green(
	no number primary key,
	writer varchar2(100),
	title varchar2(1000) not null,
	content varchar2(4000),
	hit number,
	postdate date
);

drop sequence green_seq;
create sequence green_seq
start with 1000
increment by 1
maxvalue 999999
nocycle
nocache;