package com.koreait.quiz2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		String resourceLocation = "classpath:app-context2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		Person alice = ctx.getBean("alice", Person.class);
		alice.personInfo();
		
		ctx.close();
	}
}
