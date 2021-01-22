package com.koreait.quiz1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GugudanMain {

	public static void main(String[] args) {
		
		String recourceLocation = "classpath:app-context1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(recourceLocation);
		
		Gugudan gugudan = ctx.getBean("gugudan1", Gugudan.class);
		
		gugudan.gugudan();

	}

}
