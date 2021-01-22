package com.koreait.spring;

public class Speaker {
	
	private int volume;
	
	public void volumeUp(int volume) {
		this.volume += volume;
		if(this.volume > 100 ) {
			this.volume = 100;
		}
		System.out.println("현재 볼륨: " + this.volume);
	}
	
	public void volumeDown(int volume) {
		this.volume -= volume;
		if(this.volume < 0 ) {
			this.volume = 0;
		}
		System.out.println("현재 볼륨: " + this.volume);
	}
}