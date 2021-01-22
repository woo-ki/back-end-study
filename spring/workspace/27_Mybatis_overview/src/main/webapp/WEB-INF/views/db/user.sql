drop sequence users_seq;
create sequence users_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;

drop table users;
create table users (
	no number primary key,
	name varchar2(50),
	phone varchar2(50)
);

insert into users values (users_seq.nextval, '가길동', '010-0000-0000');
insert into users values (users_seq.nextval, '나길동', '010-1111-1111');
insert into users values (users_seq.nextval, '다길동', '010-2222-2222');