drop table blue;
create table blue (
	no number primary key,
	writer varchar2(100),
	title varchar2(1000) not null,
	content varchar2(4000),
	filename varchar2(300),
	postdate date
);

drop sequence blue_seq;
create sequence blue_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;