package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 안녕. 나는 Controller야.
@Controller
public class BoardController {

	// URLMapping 처리는 메소드가 담당합니다.
	// 모든 메소드는 @RequestMapping 애너테이션을 추가해서 URLMapping을 처리합니다.
	
	// 1. 시작 페이지 만들기
	// http://localhost:9090/mvc03/ 주소와 연결되는 JSP(index.jsp)를 반환합니다.
	@RequestMapping("/")	// @RequestMapping(value="/")
	public String goIndex() {
		return "index";
	}
	
	// 2. boardInsertPage.jsp로 이동하기(단순이동)
	// http://localhost:9090/mvc03/boardInsertPage 주소와 연결되는 JSP(index.jsp)를 반환합니다.
	@RequestMapping("boardInsertPage")	// @RequestMapping("/boardInsertPage") 슬래시로 시작해도 차이가 없다.
	public String goBoardInsertPage() {
		return "board/boardInsertPage";
	}
	
	// 3.. boardInsertPage.jsp로 이동하기(단순이동)
	// http://localhost:9090/mvc03/a/b/c
	@RequestMapping("a/b/c")
	public String goBoardInsertPage2() {
		return "board/boardInsertPage";
	}
	
	// @RequestMapping을 작성할 때 URLMapping값은
	// 슬래시(/)로 시작해도 되고, 없어도 되지만.
	// 슬래시(/)를 안 넣는 것으로 연습하겠습니다.
}
