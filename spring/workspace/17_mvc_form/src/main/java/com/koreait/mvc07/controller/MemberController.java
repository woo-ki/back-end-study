package com.koreait.mvc07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(value="member/loginPage", method=RequestMethod.GET)
	// @RequestMapping(value="member/loginPage") <a href="member/loginPage"> 태그에 의해서 이동되는 매핑
	public String goLoginPage() {
		return "member/loginPage";
	}
	
	@RequestMapping(value="member/login.do", method=RequestMethod.POST)
	public String goLogin(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "member/loginResult";
	}
}
