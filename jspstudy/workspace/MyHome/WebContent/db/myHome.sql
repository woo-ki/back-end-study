drop sequence member_seq;
drop sequence guest_seq;
drop sequence bbs_seq;
drop sequence reply_seq;
drop sequence board_seq;
drop table guest;
drop table reply;
drop table bbs;
drop table board;
drop table member;


create sequence member_seq start with 1 increment by 1 maxvalue 999999 nocycle nocache;
create sequence guest_seq start with 1 increment by 1 maxvalue 999999 nocycle nocache;
create sequence bbs_seq start with 1 increment by 1 maxvalue 999999 nocycle nocache;
create sequence reply_seq start with 1 increment by 1 maxvalue 999999 nocycle nocache;
create sequence board_seq start with 1 increment by 1 maxvalue 999999 nocycle nocache;

create table member (
	mno number primary key,
	mid varchar2(30) not null unique,
	mpw varchar2(30) not null,
	mname varchar2(30),
	memail varchar2(50) not null unique,
	mphone varchar2(20),
	maddress varchar2(100),
	mregdate date
);
create table board (
	bno number primary key,
	mid varchar2(30) references member(mid),
	btitle varchar2(1000) not null,
	bcontent varchar2(4000),
	bip varchar2(20),
	bhit number,
	bdate date,	-- 최초 작성일
	blastmodify date,	-- 최종수정일
	bdelete number,	-- 삭제여부(삭제: -1, 정상: 0)
	bgroup number,	-- 게시글이 같은 그룹인가?(어떤 게시글과 거기에 달린 댓글들은 모두 같은 그룹)
	bgroupord number,	-- 게시글 그룹내 표시 순서
	bdepth number	-- 게시글인가? 댓글인가?(게시글: 0, 댓글: 1이상)
);
create table guest (
	gno number primary key,
	gwriter varchar2(100) not null,
	gtitle varchar2(1000) not null,
	gcontent varchar2(4000),
	gpw varchar2(20) not null,
	gfilename varchar2(300),
	gpostdate date
);
create table bbs (
	bbs_no number primary key,
	bbs_writer varchar2(100) not null,
	bbs_title varchar2(1000) not null,
	bbs_content varchar2(4000),
	bbs_pw varchar2(20) not null,
	bbs_hit number,
	bbs_ip varchar2(20),
	bbs_date date
);
create table reply (
	rno number primary key,
	rwriter varchar2(100) not null,
	rcontent varchar2(4000),
	rpw varchar2(20) not null,
	rip varchar2(20),
	rdate date,
	bbs_no number references bbs(bbs_no)
);

insert into member values (member_seq.nextval, 'admin', '1111', '관리자', 'admin@myhome.com', '010-0000-0000', '경기도 안산시', sysdate);
insert into member values (member_seq.nextval, 'user1', '1111', '사용자1', 'user1@myhome.com', '010-1111-1111', '경기도 시흥시', sysdate);
insert into member values (member_seq.nextval, 'user2', '1111', '사용자2', 'user2@myhome.com', '010-2222-2222', '경기도 성남시', sysdate);
insert into member values (member_seq.nextval, 'user3', '1111', '사용자3', 'user3@myhome.com', '010-3333-3333', '서울', sysdate);
insert into member values (member_seq.nextval, 'user4', '1111', '사용자4', 'user4@myhome.com', '010-4444-4444', '제주', sysdate);
insert into member values (member_seq.nextval, 'user5', '1111', '사용자5', 'user5@myhome.com', '010-5555-5555', '인천 ', sysdate);
insert into bbs values (bbs_seq.nextval, '가길동', '질문입니다1', '이게 뭔가요1?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '나길동', '질문입니다2', '이게 뭔가요2?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '다길동', '질문입니다3', '이게 뭔가요3?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '라길동', '질문입니다4', '이게 뭔가요4?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '마길동', '질문입니다5', '이게 뭔가요5?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '바길동', '질문입니다6', '이게 뭔가요6?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '사길동', '질문입니다7', '이게 뭔가요7?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '아길동', '질문입니다8', '이게 뭔가요8?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '자길동', '질문입니다9', '이게 뭔가요9?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '차길동', '질문입니다10', '이게 뭔가요10?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '카길동', '질문입니다11', '이게 뭔가요11?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '타길동', '질문입니다12', '이게 뭔가요12?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '파길동', '질문입니다13', '이게 뭔가요13?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '하길동', '질문입니다14', '이게 뭔가요14?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '제임스', '질문입니다15', '이게 뭔가요15?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '앨리스', '질문입니다16', '이게 뭔가요16?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '스미스', '질문입니다17', '이게 뭔가요17?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '데이빗', '질문입니다18', '이게 뭔가요18?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '브라운', '질문입니다19', '이게 뭔가요19?', '1111', 0, '127.0.0.1', sysdate);
insert into bbs values (bbs_seq.nextval, '에밀리', '질문입니다20', '이게 뭔가요20?', '1111', 0, '127.0.0.1', sysdate);
update board set bdelete = 0 where bno = 8;