drop sequence contact_seq;
drop table contact;

create sequence contact_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;

create table contact (
	no number primary key,
	name varchar2(100),
	phone varchar2(50),
	address varchar2(200),
	email varchar2(100),
	note varchar2(1000)
);

insert into contact values (contact_seq.nextval, '제임스', '010-0000-0000', '서울시 마포구', 'james@app.com', '친구');