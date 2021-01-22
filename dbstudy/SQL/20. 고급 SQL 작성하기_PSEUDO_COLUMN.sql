-- 시퀀스와 테이블
drop sequence board_seq;
drop table board;

create table board (
    board_no number primary key,
    board_title varchar2(2000) not null,
    board_content varchar2(4000)
);

create sequence board_seq
increment by 1  -- 번호는 1씩 증가한다.
start with 1    -- 번호는 1부터 시작한다.
nomaxvalue      -- 최대번호는 없다.
nominvalue      -- 최소번호는 없다.
nocycle         -- 번호는 순환되지 않는다.
nocache;        -- cache를 사용하지 않는다.

insert into board values (board_seq.nextval, '공지사항', '오늘 재평가가 있습니다.');
insert into board values (board_seq.nextval, '알림', '내일은 본평가가 있습니다.');
insert into board values (board_seq.nextval, '라라랄', 'nice to meet you.');
insert into board values (board_seq.nextval, '후암', '심시맹.');
insert into board values (board_seq.nextval, '뭐야', '뭐긴뭐야.');

-- rownum
-- 가상이다 (실제하기 않는다)
-- 1이 포함된 숫자는 조회가 가능하다.
-- 실제 칼럼으로 바꿔서 원하는 값이나 범위를 사용할 수 있다.
select * from board where rownum >= 1;

-- 1. 게시글의 제목을 가나다순으로 정렬하고 첫 번째 게시글을 조회하시오
select
    *
from
    (select * from board order by board_title) a
where
    rownum = 1;
    
-- 2. 게시글의 제목을 가나다 역순으로 정렬하고 두 번째 게시글을 조회하시오
select
    *
from
    (select rownum as rn, board_no, board_title, board_content from (select * from board order by board_title desc) a) a
where
    rn = 2;
    
select rownum as rn, board_no, board_title, board_content from (select * from board order by board_title desc) a
