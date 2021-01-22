package com.koreait.quiz1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		String resourceLocation = "classpath:app-context1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		Soldier s1 = ctx.getBean("soldier1", Soldier.class);
		Soldier s2 = ctx.getBean("soldier2", Soldier.class);
		
		s1.soldierInfo();
		s2.soldierInfo();
		
		ctx.close();

	}

}
