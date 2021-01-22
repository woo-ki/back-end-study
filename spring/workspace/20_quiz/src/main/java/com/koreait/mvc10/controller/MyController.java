package com.koreait.mvc10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc10.dto.Calculator;

@Controller
public class MyController {

	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="calc", method=RequestMethod.GET)
	public String result(@ModelAttribute("calculator") Calculator calculator) {
		calculator.setResult();	// 연산이 수행됩니다.
		if(calculator.getViewName().equals("result")) {
			return calculator.getViewName();	// result.jsp로 이동 포워드
		} else {
			return "redirect:" + calculator.getViewName();
			// return "redirect:/";	// index로 이동하는 매핑값(/)을 이용합니다.
		}
	}
}
