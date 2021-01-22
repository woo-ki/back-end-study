package com.koreait.mvc08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc08.dto.PersonDto;

@Controller
public class MyController {

	/*
		@RequestMapping(value={"/", "index"})
		연결되는 URLMapping 값이 2개 이상인 경우에 사용하시면 됩니다.
	*/
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(value="v01", method=RequestMethod.GET)
	public String view01(PersonDto personDto, Model model) {
		model.addAttribute("personDto", personDto);
		return "view01";
	}
	
	@RequestMapping(value="v02", method=RequestMethod.GET)
	public String view02(PersonDto personDto, Model model) {
		model.addAttribute("personDto", personDto);
		return "redirect:v03";	// redirect입니다. redirect:매핑값(RequestMapping)
	}
	
	@RequestMapping(value="v03", method=RequestMethod.GET)
	public String view03() {
		return "view03";
	}
	
	/*
		redirect를 할 때 값을 전달하고 싶으면,
		새로운 파라미터를 만들지 말고,
		RedirectAttributes redirect를 선언하고, addFlashAttribute()메소드로 값을 저장하면 됩니다.
	*/
	@RequestMapping(value="v04", method=RequestMethod.GET)
	public String view04(PersonDto personDto, RedirectAttributes redirect) {
		redirect.addFlashAttribute("personDto", personDto);
		redirect.addFlashAttribute("hi", "hi");
		redirect.addAttribute("name", personDto.getName());
		redirect.addAttribute("age", personDto.getAge());
		redirect.addAttribute("hi", "hi");
		return "redirect:v05";
	}
	
	@RequestMapping(value="v05", method=RequestMethod.GET)
	public String view05() {
		return "view05";
	}
}