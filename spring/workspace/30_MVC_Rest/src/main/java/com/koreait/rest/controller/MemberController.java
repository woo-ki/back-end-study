package com.koreait.rest.controller;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.rest.command.MemberCommand;
import com.koreait.rest.command.MemberDeleteCommand;
import com.koreait.rest.command.MemberInsertCommand;
import com.koreait.rest.command.MemberListCommand;
import com.koreait.rest.command.MemberListCommand2;
import com.koreait.rest.command.MemberUpdateCommand;
import com.koreait.rest.command.MemberViewCommand;
import com.koreait.rest.dto.MemberDto;

@RestController
public class MemberController {
	MemberCommand command;
	@Autowired
	SqlSession sqlSession;
	
	@GetMapping(value="member", produces="application/json; charset=utf-8")
	public Map<String, Object> memberList(Model model) {
		command = new MemberListCommand();
		return command.execute(sqlSession, model);
	}
	
	@GetMapping(value="memberPaging", produces="application/json; charset=utf-8")
	public Map<String, Object> memberPaging(
			@RequestParam("page") int page,
			Model model) {
		model.addAttribute("page", page);
		command = new MemberListCommand2();
		return command.execute(sqlSession, model);
	}
	
	@PostMapping(value="member", produces="application/json; charset=utf-8")
	public Map<String, Object> memberInsert(@RequestBody MemberDto memberDto, Model model) {
		if(memberDto != null) {
			model.addAttribute("memberDto", memberDto);
		}
		command = new MemberInsertCommand();
		return command.execute(sqlSession, model);
	}
	
	@GetMapping(value="member/{no}", produces="application/json; charset=utf-8")
	public Map<String, Object> memberView(
			@PathVariable("no") int no,
			Model model) {
		model.addAttribute("no", no);
		command = new MemberViewCommand();
		return command.execute(sqlSession, model);
	}
	
	@DeleteMapping(value="member/{no}", produces="application/json; charset=utf-8")
	public Map<String, Object> memberDelete(
			@PathVariable("no") int no,
			Model model) {
		model.addAttribute("no", no);
		command = new MemberDeleteCommand();
		return command.execute(sqlSession, model);
	}
	
	@PutMapping(value="member", produces="application/json; charset=utf-8")
	public Map<String, Object> memberUpdate(@RequestBody MemberDto memberDto, Model model) {
		if(memberDto != null) {
			model.addAttribute("memberDto", memberDto);
		}
		command = new MemberUpdateCommand();
		return command.execute(sqlSession, model);
	}
}
