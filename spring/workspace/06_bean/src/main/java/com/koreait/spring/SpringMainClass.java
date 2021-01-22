package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		// app-context.xml이 AppContext.java를 가져왔어요.
		// XML용 GenricXmlApplicationContext 클래스를 사용합니다.
		String resourceLocation = "classpath:app-context.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		Person p1 = ctx.getBean("person1", Person.class);
		Person p2 = ctx.getBean("person2", Person.class);
		
		p1.personInfo();
		p2.personInfo();
		
		ctx.close();
	}

}
