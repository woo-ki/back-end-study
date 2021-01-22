package com.koreait.quiz1;

public class Gun {
	private String model;
	private int bullet;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	public void gunInfo() {
		System.out.println("총기모델: " + model);
		System.out.println("총알: " + bullet + "발");
	}
}
