package com.koreait.quiz3;

import java.util.ArrayList;

public class Exam {
	// Field
	private double average;
	private char grade;
	
	public void examResult(ArrayList<Integer> scoreList) {
		double total = 0;
		for(int list : scoreList) {
			total += list;
		}
		average = total / scoreList.size();
		if(average >= 90) {
			grade = 'A';
		} else if(average >= 80) {
			grade = 'B';
		} else if(average >= 70) {
			grade = 'C';
		} else if(average >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("average: " + average);
		System.out.println("grade: " + grade);
	}
}
