package com.koreait.spring;

public class Person {

	private String name;
	private Car myCar;
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getMyCar() {
		return myCar;
	}

	public void setMyCar(Car myCar) {
		this.myCar = myCar;
	}
	
	public void personInfo() {
		System.out.println("이름: " + name);
		myCar.carInfo();
	}
}
