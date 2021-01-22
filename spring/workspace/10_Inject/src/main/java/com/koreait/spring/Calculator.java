package com.koreait.spring;

import org.springframework.stereotype.Component;

// 나는 calc라고 해.
@Component("calculator")	// <bean id="calculator">로 이름을 주었어요.
public class Calculator {
	public void add(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
	}
	public void subtract(int a, int b) {
		System.out.println(a + "-" + b + "=" + (a - b));
	}
	public void multiply(int a, int b) {
		System.out.println(a + "*" + b + "=" + (a * b));
	}
	public void divide(int a, int b) {
		System.out.println(a + "/" + b + "=" + (a / b));
	}
}
