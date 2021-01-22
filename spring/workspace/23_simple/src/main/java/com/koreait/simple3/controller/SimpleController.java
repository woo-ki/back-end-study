package com.koreait.simple3.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.simple3.command.SimpleDeleteCommand;
import com.koreait.simple3.command.SimpleInsertCommand;
import com.koreait.simple3.command.SimpleListCommand;
import com.koreait.simple3.command.SimpleUpdateCommand;
import com.koreait.simple3.command.SimpleViewCommand;
import com.koreait.simple3.config.AppContext;
import com.koreait.simple3.dto.SimpleDto;

@Controller
public class SimpleController {
	/*
		Java로 빈을 만들 때
		1. Controller는 AnnotationConfigApplicationContext ctx를 필드로 선언 해 둔다.
		2. 모든 command는 ctx.getBean()으로 필요하면 가져와서 쓴다.
		3. com.springsource.net.sf.cglib-2.1.3.jar 라이브러리를 추가해 줍니다.
			1) tomcat/lib 폴더에 추가할 수 있고,
			2) 아니면 프로젝트 하위 Maven Dependencies 폴더에 붙여넣기
	*/
	
	// field
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	private SimpleListCommand listCommand = ctx.getBean("listCommand", SimpleListCommand.class);
	private	SimpleViewCommand viewCommand = ctx.getBean("viewCommand", SimpleViewCommand.class);
	private	SimpleInsertCommand insertCommand = ctx.getBean("insertCommand", SimpleInsertCommand.class);
	private	SimpleUpdateCommand updateCommand = ctx.getBean("updateCommand", SimpleUpdateCommand.class);
	private	SimpleDeleteCommand deleteCommand = ctx.getBean("deleteCommand", SimpleDeleteCommand.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="simpleList.do", method=RequestMethod.GET)
	public String simpleList(Model model) {
		listCommand.execute(ctx, model);
		return "simple/simpleList";
	}
	
	@RequestMapping(value="simpleInsertPage.do", method=RequestMethod.GET)
	public String simpleInsertPage() {
		return "simple/simpleInsertPage";
	}
	
	@RequestMapping(value="simpleInsert.do", method=RequestMethod.POST)
	public String simpleInsert(@ModelAttribute("simpleDto") SimpleDto simpleDto, Model model) {
		insertCommand.execute(ctx, model);
		return "redirect:simpleList.do";
	}
	
	@RequestMapping(value="simpleViewPage.do", method=RequestMethod.GET)
	public String simpleViewPage(@ModelAttribute("no") int no, Model model) {
		viewCommand.execute(ctx, model);
		return "simple/simpleViewPage";
	}
	
	@RequestMapping(value="simpleUpdatePage.do", method=RequestMethod.POST)
	public String simpleUpdatePage(@ModelAttribute("simpleDto") SimpleDto simpleDto) {
		return "simple/simpleUpdatePage";
	}
	
	@RequestMapping(value="simpleUpdate.do", method=RequestMethod.POST)
	public String simpleUpdate(@ModelAttribute("simpleDto") SimpleDto simpleDto, Model model) {
		updateCommand.execute(ctx, model);
		return "redirect:simpleViewPage.do?no=" + simpleDto.getNo();
	}
	
	@RequestMapping(value="simpleDelete.do", method=RequestMethod.POST)
	public String simpleDelete(@ModelAttribute("no") int no, Model model) {
		deleteCommand.execute(ctx, model);
		model.asMap().clear();
		return "redirect:simpleList.do";
	}
}