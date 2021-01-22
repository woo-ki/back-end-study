package com.koreait.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*
	app-context.xml에 정의된 Bean을
	AppContext.java로 가져올 수 있어요.
	
	방법
	1. AppContext 클래스에 @ImportResource(XML파일) 애너테이션을 추가한다.
*/

@ImportResource("classpath:app-context.xml")
@Configuration
public class AppContext {

	@Bean
	public Student student2() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		scores.add(87);
		scores.add(96);
		scores.add(67);
		scores.add(87);
		scores.add(80);
		HashSet<String> volunteers = new HashSet<String>();
		volunteers.add("병원");
		volunteers.add("복지관");
		volunteers.add("어린이집");
		HashMap<String, String> homeInfo = new HashMap<String, String>();
		homeInfo.put("address", "seoul");
		homeInfo.put("phone", "010-2222-2222");
		return new Student("맷데이먼", scores, volunteers, homeInfo);
	}
	
}
