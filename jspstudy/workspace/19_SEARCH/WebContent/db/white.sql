drop table white;
drop sequence white_seq;

create table white(
	no number primary key,
	title varchar2(1000) not null,
	content varchar2(4000),
	postdate timestamp
);

create sequence white_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;

insert into WHITE values (white_seq.nextval, '어제의 아침', '만두국', sysdate);
insert into WHITE values (white_seq.nextval, '어제의 점심', '순두부찌개', sysdate);
insert into WHITE values (white_seq.nextval, '어제의 저녁', '김밥', sysdate);
insert into WHITE values (white_seq.nextval, '오늘의 아침', '잡채', sysdate);
insert into WHITE values (white_seq.nextval, '오늘의 점심', '김치찌개', sysdate);
insert into WHITE values (white_seq.nextval, '오늘의 저녁', '삼겹살', sysdate);
insert into WHITE values (white_seq.nextval, '내일의 아침', '된장찌개', sysdate);
insert into WHITE values (white_seq.nextval, '내일의 점심', '토스트', sysdate);
insert into WHITE values (white_seq.nextval, '내일의 저녁', '피자', sysdate);
insert into WHITE values (white_seq.nextval, '모레의 아침', '미역국', sysdate);
insert into WHITE values (white_seq.nextval, '모레의 점심', '김치국', sysdate);
insert into WHITE values (white_seq.nextval, '모레의 저녁', '굴국', sysdate);


select * from WHITE;

create table emp as
select * from hr.employees;

select * from all_users;