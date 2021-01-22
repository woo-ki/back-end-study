drop table lime;
create table lime (
	no number primary key,
	writer varchar2(100),
	title varchar2(1000) not null,
	content varchar2(4000),
	postdate timestamp
);
drop sequence lime_seq;
create sequence lime_seq
start with 1
increment by 1
maxvalue 9999999
nocycle
nocache;