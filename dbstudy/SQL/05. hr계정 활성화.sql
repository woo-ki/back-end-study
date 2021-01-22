-- 검색: 교육용 계정 HR
-- 1. 관리자 권한을 가진 계정으로 접속
-- 2. HR계정의 락을 풀고,
alter user hr account unlock;
-- 3. HR계정에 새로운 비밀번호 설정
alter user hr identified by 1111;
-- 4. HR, 새로운 비밀번호로 접속