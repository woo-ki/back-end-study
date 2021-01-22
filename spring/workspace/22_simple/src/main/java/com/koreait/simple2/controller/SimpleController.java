package com.koreait.simple2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.simple2.command.SimpleDeleteCommand;
import com.koreait.simple2.command.SimpleInsertCommand;
import com.koreait.simple2.command.SimpleListCommand;
import com.koreait.simple2.command.SimpleUpdateCommand;
import com.koreait.simple2.command.SimpleViewCommand;
import com.koreait.simple2.dto.SimpleDto;

@Controller
public class SimpleController {
	// root-context.xml에 결정된 Bean 중에서
	// command 들을 필요로 하는 곳입니다.
	
	/*
		1. 일일이 생성하기
		@Autowired
		private SimpleListCommand simpleListCommand;
		@Autowired
		private SimpleViewCommand simpleViewCommand;
		...
	*/
	
	//	@Autowired의 적용 대상은 필드, 메소드 모두 가능합니다.
	/*
		2. 메소드의 매개변수에 배치해서 한 번에 생성하기
		@Autowired
		public void setCommand(
				SimpleListCommand simpleListCommand,
				SimpleViewCommand simpleViewCommand,
				SimpleInsertCommand simpleInsertCommand,
				SimpleUpdateCommand simpleUpdateCommand,
				SimpleDeleteCommand simpleDeleteCommand) {
			this.simpleListCommand = simpleListCommand;
			this.simpleViewCommand = simpleViewCommand;
			this.simpleInsertCommand = simpleInsertCommand;
			this.simpleUpdateCommand = simpleUpdateCommand;
			this.simpleDeleteCommand = simpleDeleteCommand;
		}
	*/
	
	// field
	private SimpleListCommand simpleListCommand;
	private	SimpleViewCommand simpleViewCommand;
	private	SimpleInsertCommand simpleInsertCommand;
	private	SimpleUpdateCommand simpleUpdateCommand;
	private	SimpleDeleteCommand simpleDeleteCommand;
	
	@Autowired
	public void setCommand(
			SimpleListCommand simpleListCommand,
			SimpleViewCommand simpleViewCommand,
			SimpleInsertCommand simpleInsertCommand,
			SimpleUpdateCommand simpleUpdateCommand,
			SimpleDeleteCommand simpleDeleteCommand) {
		this.simpleListCommand = simpleListCommand;
		this.simpleViewCommand = simpleViewCommand;
		this.simpleInsertCommand = simpleInsertCommand;
		this.simpleUpdateCommand = simpleUpdateCommand;
		this.simpleDeleteCommand = simpleDeleteCommand;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="simpleList.do", method=RequestMethod.GET)
	public String simpleList(Model model) {
		simpleListCommand.execute(model);
		return "simple/simpleList";
	}
	
	@RequestMapping(value="simpleInsertPage.do", method=RequestMethod.GET)
	public String simpleInsertPage() {
		return "simple/simpleInsertPage";
	}
	
	@RequestMapping(value="simpleInsert.do", method=RequestMethod.POST)
	public String simpleInsert(SimpleDto simpleDto, Model model) {
		model.addAttribute("simpleDto", simpleDto);
		simpleInsertCommand.execute(model);
		return "redirect:simpleList.do";
	}
	
	@RequestMapping(value="simpleViewPage.do", method=RequestMethod.GET)
	public String simpleViewPage(@ModelAttribute("no") int no, Model model) {
		simpleViewCommand.execute(model);
		return "simple/simpleViewPage";
	}
	
	@RequestMapping(value="simpleUpdatePage.do", method=RequestMethod.POST)
	public String simpleUpdatePage(@ModelAttribute("simpleDto") SimpleDto simpleDto) {
		return "simple/simpleUpdatePage";
	}
	
	@RequestMapping(value="simpleUpdate.do", method=RequestMethod.POST)
	public String simpleUpdate(@ModelAttribute("simpleDto") SimpleDto simpleDto, Model model) {
		simpleUpdateCommand.execute(model);
		return "redirect:simpleViewPage.do?no=" + simpleDto.getNo();
	}
	
	@RequestMapping(value="simpleDelete.do", method=RequestMethod.POST)
	public String simpleDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleDeleteCommand.execute(model);
		return "redirect:simpleList.do";
	}
}