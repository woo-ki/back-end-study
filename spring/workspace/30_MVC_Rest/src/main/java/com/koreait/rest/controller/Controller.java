package com.koreait.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	// 연습용
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	// 테이블 사용하는 실전 연습용
	@GetMapping(value="memberManagePage.do")
	public String memberManagePage() {
		return "member/memberManagePage";
	}
}
