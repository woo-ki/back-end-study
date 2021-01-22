package com.koreait.mvc06.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc06.dto.BoardDto;
import com.koreait.mvc06.dto.PersonDto;

@Controller
@RequestMapping("board")
public class BoardController {
	
	// 1. JSP에서 사용하던 방식으로 Request 를 처리해도 전혀 문제가 없습니다.
	
	@RequestMapping("v01")
	public String goView01(HttpServletRequest request, Model model) {
		// 매개변수
		// 1. HttpServletRequest request: JSP-> Controller 로 넘어오는 요청을 처리합니다.
		// 2. Model model : Controller -> JSP로 넘어가는 결과값을 처리합니다.
		
		// 전달 받은 파라미터 처리
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 결과 view로 데이터 전달
		model.addAttribute("name2", name);
		model.addAttribute("age2", age);
		
		return "view01";
		
		// foward로 view01.jsp로 이동합니다.(기존 request 정보가 넘어갑니다.)
	}
	
	// 연습
	// http://localhost:9090/mvc06/board/v02?title=공지사항&hit=1
	
	// view02.jsp
	// 제목: 공지사항
	// 조회수: 1
	// 작성일: 2021-01-11
	@RequestMapping("v02")
	public String view02(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		int hit = Integer.parseInt(request.getParameter("hit"));
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		String date = s.format(System.currentTimeMillis());
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		model.addAttribute("date", date);
		return "view02";
	}
	
	// 2. @RequestParam
	// request로 전달되는 파라미터를 처리하는 애너테이
	@RequestMapping("v03")
	public String goView03(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		// @RequestParam("name") String name : 파라미터 name을 String name에 저장하세요.
		// @RequestParam("age") int age : 파라미터 age를 int age에 저장하세요.
		
		// model에 속성으로 저장합니다.
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "view03";
	}
	
	// 연습
	// http://localhost:9090/mvc06/board/v04?title=공지사항&hit=1
	// view04.jsp
	// 제목: 공지사항
	// 조회수: 1
	// 작성일: 2021-01-11
	@RequestMapping("v04")
	public String goView04(@RequestParam("title") String title, @RequestParam("hit") int hit, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		String date = s.format(System.currentTimeMillis());
		model.addAttribute("date", date);
		return "view04";
	}
	
	// 3. @RequestParam의 추가 속성
	@RequestMapping("v05")
	public String goView05(
			@RequestParam(value = "name", required = false, defaultValue = "알 수 없음") String name,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age,
			Model model) {
		// 받은 파라미터를 다시 model에 다시 저장한다.
		// name = name == null ? "알 수 없음" : name;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "view05";
	}
	
	// 연습
	// http://localhost:9090/mvc06/board/v06
	// view06.jsp
	// 제목: 공지사항
	// 조회수: 1
	// 작성일: 2021-01-12
	@RequestMapping("v06")
	public String goView06(
			@RequestParam(value="title", required=false, defaultValue="공지사항") String title,
			@RequestParam(value="hit", required=false, defaultValue="1") int hit,
			Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		String date = s.format(System.currentTimeMillis());
		model.addAttribute("date", date);
		return "view06";
	}
	
	// 4. Dto
	@RequestMapping("v07")
	public String goView07(PersonDto personDto, Model model) {
		// 파라미터 name과 age가 personDto에 저장된다.
		model.addAttribute("name", personDto.getName());
		model.addAttribute("age", personDto.getAge());
		return "view07";
	}
	
	// 연습
	// http://localhost:9090/mvc06/board/v08?title=공지사항&hit=1
	// view08.jsp
	// 제목: 공지사항
	// 조회수: 1
	// 작성일: 2021-01-12
	@RequestMapping("v08")
	public String goView08(BoardDto boardDto, Model model) {
		model.addAttribute("title", boardDto.getTitle());
		model.addAttribute("hit", boardDto.getHit());
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		String date = s.format(System.currentTimeMillis());
		model.addAttribute("date", date);
		return "view08";
	}
	
	// 5. @ModelAttribute
	@RequestMapping("v09")
	public String goView09(
			@ModelAttribute("name") String name,
			@ModelAttribute("age") int age) {
		return "view09";
	}
	@RequestMapping("v10")
	public String goView09(@ModelAttribute("personDto") PersonDto personDto) {
		return "view10";
	}
	
	// 연습
	// http://localhost:9090/mvc06/board/v11?title=공지사항&hit=1
	// view11.jsp
	// 제목: 공지사항
	// 조회수: 1
	// 작성일: 2021-01-12
	@RequestMapping("v11")
	public String goView11(@ModelAttribute("boardDto") BoardDto boardDto, Model model) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		String date = s.format(System.currentTimeMillis());
		model.addAttribute("date", date);
		return "view11";
	}
}
