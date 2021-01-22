package com.koreait.quiz3;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	// Field
	private String name;
	private int age;
	private HashMap<String, String> homeInfo;
	private ArrayList<Integer> scoreList;
	private Exam exam;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public HashMap<String, String> getHomeInfo() {
		return homeInfo;
	}
	public void setHomeInfo(HashMap<String, String> homeInfo) {
		this.homeInfo = homeInfo;
	}
	public ArrayList<Integer> getScoreList() {
		return scoreList;
	}
	public void setScoreList(ArrayList<Integer> scoreList) {
		this.scoreList = scoreList;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void studentInfo() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("home's address: " + homeInfo.get("address"));
		System.out.println("home's phone: " + homeInfo.get("phone"));
		System.out.println("scoreList: " + scoreList);
		exam.examResult(scoreList);
	}
}
