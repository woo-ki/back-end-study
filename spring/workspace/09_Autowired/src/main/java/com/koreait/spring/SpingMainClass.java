package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpingMainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:app-context.xml");
		
		/*
			<bean id="tv" class="com.koreait.spring.TV" />
			아래 코드는 위의 Bean을 생성합니다.
		*/
		TV tv = ctx.getBean("tv", TV.class);
		tv.channelUp();
		tv.channelDown();
		tv.volumeUp(5);
		tv.volumeDown(5);
		TV tv2 = ctx.getBean("tv2", TV.class);
		tv2.volumeUp(4);
		
		tv.volumeUp(4);
		tv2.volumeUp(2);
		
		ctx.close();
	}
}
