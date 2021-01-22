package com.koreait.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class TV {
	/*
		@Autowired
		이 애너테이션이 붙어 있는 객체 선언부(private Speaker speaker)
		는 해당 Bean(객체)를 자동으로 찾아서 생성 해준다.
		
		xml이라면 <bean id="speaker" class="Speaker" /> 를 자동으로 찾고,
		java라면 public Speaker speaker() {} 를 자동으로 찾는다.
	*/
	@Autowired	// 바로 아래의 선언부만 해당
	private Speaker speaker1;
	private int channel;
	
	public void channelUp() {
		channel++;
		if(channel > 100) {
			channel = 0;
		}
		System.out.println("현재 채널: " + channel);
	}
	
	public void channelDown() {
		channel--;
		if(channel < 0) {
			channel = 100;
		}
		System.out.println("현재 채널: " + channel);
	}
	
	public void volumeUp(int volume) {
		speaker1.volumeUp(volume);
	}
	
	public void volumeDown(int volume) {
		speaker1.volumeDown(volume);
	}
}
