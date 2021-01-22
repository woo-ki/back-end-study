package com.koreait.quiz1;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext1 {

	@Bean
	public Gun gun1() {
		Gun gun = new Gun();
		gun.setModel("K1");
		gun.setBullet(10);
		return gun;
	}
	
	@Bean
	public Soldier soldier1() {
		Soldier s = new Soldier();
		s.setName("김상사");
		s.setGun(gun1());
		HashMap<String, String> armyInfo = new HashMap<String, String>();
		armyInfo.put("name", "1사단");
		armyInfo.put("location", "산속");
		s.setArmyInfo(armyInfo);
		return s;
	}
}
