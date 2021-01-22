package ex04_constructor;

import java.util.Arrays;

class Student {
	// field
	String name;
	String school;
	int[] score;
	double average;
	boolean isPass;
	
	// 생성자
	Student(String name, String school) {
		this.name = name;
		this.school = school;
	}
	
	// method
	void doExam() {
		score = new int[3];
		for(int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random() * 51) + 50;
		}
		int total = 0;
		for(int i = 0; i < score.length; i++) {
			total += score[i];
		}
		average = total / (double)score.length;
		isPass = average >= 80;
	}
	
	void info() {
		System.out.println("이름: " + name);
		System.out.println("학교: " + school);
		System.out.println("점수: " + Arrays.toString(score));
		System.out.println("평균: " + average);
		System.out.println(isPass ? "합격" : "불합격");
	}
}

public class Ex05_Student {

	public static void main(String[] args) {

		Student student = new Student("제임스", "서강대");
		
		student.doExam();	// 시험본다. (50~100 사이 랜덤 3개 생성)
		student.info();
		
		// 이름: 제임스
		// 학교: 서강대
		// 점수: [50, 75, 100]
		// 평균 : 75.0점
		// 불합격 (평균 80점 이상 합격)
		
	}

}
