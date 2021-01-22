package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// app-context.xml 에 정의된 빈(bean)을 생성하는 클래스가 있습니다.
		// GenericXmlApplicationContext 클래스입니다.
		
		// AbstractApplicationContext는 GenericXmlApplicationContext의 슈퍼클래스입니다.
		
		String resouceLocations = "classpath:app-context.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resouceLocations);
		
		// cal1과 cal2의 생성을 app-context.xml에서 처리합니다.
		// 개발자가 직접 생성하기 않고, app-context.xml에게 반을 요청하는 방식입니다.(getBean)
		
		// 빈의 새성 권한을 스프링프레임워크가 가져갑니다.
		// 개발자가 빈을 생성하지 않습니다.
		// IoC : Inversion of Control (제어의 역전)
		
		Calculator cal1 = ctx.getBean("calculator1", Calculator.class);
		cal1.add(10, 3);
		cal1.subtract(10, 3);
		cal1.multiply(10, 3);
		cal1.divide(10, 3);
		
		Calculator cal2 = ctx.getBean("calculator2", Calculator.class);
		cal2.add(100, 30);
		cal2.subtract(100, 30);
		cal2.multiply(100, 30);
		cal2.divide(100, 30);
		
		EngineerCalculator eCal1 = ctx.getBean("eCalculator1", EngineerCalculator.class);
		eCal1.add();
		eCal1.subtract();
		eCal1.multiply();
		eCal1.divide();
		
		EngineerCalculator eCal2 = ctx.getBean("eCalculator2", EngineerCalculator.class);
		eCal2.add();
		eCal2.subtract();
		eCal2.multiply();
		eCal2.divide();
		
		ctx.close();

	}

}
