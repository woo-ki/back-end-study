-- M:N 관계 예제 (학생 - 수강신청 - 과목)
CREATE TABLE student (
  studentNo NUMBER PRIMARY KEY,
  studentName VARCHAR2(10),
  studentAge NUMBER
);

CREATE TABLE course (
  courseCode CHAR(1) PRIMARY KEY,
  courseName CHAR(10),
  professor CHAR(10)
);

CREATE TABLE enroll (
  enrollNo NUMBER PRIMARY KEY,
  studentNo NUMBER REFERENCES student(studentNo),
  courseCode CHAR(1) REFERENCES course(courseCode)
);

drop table class;

drop table student;

DROP TABLE SUBJECT;
