drop sequence board_seq;
create sequence board_seq
start with 1
increment by 1
maxvalue 999999
nocycle
nocache;

drop table board;
create table board(
	no number primary key,
	writer varchar2(100),
	title varchar2(100),
	content varchar2(4000),
	filename varchar2(300),
	regdate date
);

select * from board;