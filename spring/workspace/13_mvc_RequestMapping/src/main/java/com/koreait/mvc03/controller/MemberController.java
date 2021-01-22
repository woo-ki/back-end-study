package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
	ReqeustMapping의 값은 주소(URL)에서 사용한다.
	실제 폴더 구조와 상관이 없다.
*/

@Controller

@RequestMapping("member")	// 이 컨트롤러의 모든 RequestMapping은 member로 시작합니다.(자동으로 추가됩니다)
public class MemberController {
	
	// 1. signUpPage.jsp 이동하기 (단순이동)
	// http://localhost:9090/mvc03/member/signUpPage
	
	@RequestMapping("signUpPage")
	public String signUpPage() {
		// return 에서 실제 폴더와 파일명을 작성합니다.
		return "member/signUpPage";
	}

}
