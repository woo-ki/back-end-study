package com.koreait.spring;

import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<String> hobbies;
	
	public Person() {}

	public Person(String name, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public void personInfo() {
		System.out.println("이름: " + name);
		System.out.println("취미: " + hobbies);
	}
}
