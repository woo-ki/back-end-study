package com.koreait.quiz3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		String resourceLocation = "classpath:app-context3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		Student david = ctx.getBean("student", Student.class);
		david.studentInfo();
		
		ctx.close();

	}

}
