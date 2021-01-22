package ex01_oop;

class Exam {
	// field
	String examName;
	int kor, eng, math;	//0~100
	double avg;
	char grade;		// A, B, C, D, F / 90, 80, 70, 60, 나머지
	// constructor
	Exam(String examName) {
		this.examName = examName;
	}
	// method
	void setScore() {
		kor = (int)(Math.random() * 101);	// 0부터 101개 난수(0~100)
		eng = (int)(Math.random() * 101);
		math = (int)(Math.random() * 101);
	}
	void setAverage() {
		// 평균
		int total = kor + eng + math;
		avg = total / 3.0;
	}
	void setGrade() {
		// 학점
		if(avg >= 90) {
			grade = 'A';
		} else if(avg >= 80) {
			grade = 'B';
		} else if(avg >= 70) {
			grade = 'C';
		} else if(avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
	}
	void info() {
		System.out.println(examName + "의 결과");
		System.out.println("국, 영, 수: " + kor + ", " + eng + ", " + math);
		System.out.println("평균: " + avg + "(" + grade + ")");
	}

}

class Student {
	// field
	String name;
	Exam exam;
	// constructor
	Student(String name) {
		this.name = name;
	}
	// method
	void setExam(Exam exam) {
		this.exam = exam;
	}
	void setScore() {
		exam.setScore();
		exam.setAverage();
		exam.setGrade();
	}
	void info() {
		System.out.println("학생이름: " + name);
		exam.info();
	}
}

public class Ex08_Student {

	public static void main(String[] args) {

		Exam exam1 = new Exam("중간고사");
		Exam exam2 = new Exam("기말고사");
		Student s1 = new Student("홍길동");
		
		s1.setExam(exam1);
		s1.setScore();
		s1.info();
		System.out.println("---------------------");
		s1.setExam(exam2);
		s1.setScore();
		s1.info();

	}

}
