package com.koreait.quiz1;

import java.util.HashMap;

public class Soldier {
	private String name;
	private HashMap<String, String> armyInfo;
	private Gun gun;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getArmyInfo() {
		return armyInfo;
	}
	public void setArmyInfo(HashMap<String, String> armyInfo) {
		this.armyInfo = armyInfo;
	}
	public Gun getGun() {
		return gun;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public void soldierInfo() {
		System.out.println("이름: " + name);
		System.out.println("부대명: " + armyInfo.get("name"));
		System.out.println("부대위치: " + armyInfo.get("location"));
		gun.gunInfo();
	}
}
