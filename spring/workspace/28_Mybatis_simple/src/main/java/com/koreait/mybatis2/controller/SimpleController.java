package com.koreait.mybatis2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.command.SimpleDeleteCommand;
import com.koreait.mybatis2.command.SimpleInsertCommand;
import com.koreait.mybatis2.command.SimpleListCommand;
import com.koreait.mybatis2.command.SimpleUpdateCommand;
import com.koreait.mybatis2.command.SimpleViewCommand;
import com.koreait.mybatis2.dto.SimpleDto;

@Controller
public class SimpleController {
	
	private SqlSession sqlSession;
	private SimpleListCommand simpleListCommand;
	private SimpleInsertCommand simpleInsertCommand;
	private SimpleViewCommand simpleViewCommand;
	private SimpleUpdateCommand simpleUpdateCommand;
	private SimpleDeleteCommand simpleDeleteCommand;
	
	@Autowired
	public void setAll(
			SqlSession sqlSession,
			SimpleListCommand simpleListCommand,
			SimpleInsertCommand simpleInsertCommand,
			SimpleViewCommand simpleViewCommand,
			SimpleUpdateCommand simpleUpdateCommand,
			SimpleDeleteCommand simpleDeleteCommand) {
		this.sqlSession = sqlSession;
		this.simpleListCommand = simpleListCommand;
		this.simpleInsertCommand = simpleInsertCommand;
		this.simpleViewCommand = simpleViewCommand;
		this.simpleUpdateCommand = simpleUpdateCommand;
		this.simpleDeleteCommand = simpleDeleteCommand;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="simpleList.do", method=RequestMethod.GET)
	public String simpleList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleListCommand.execute(sqlSession, model);
		return "simple/simpleListPage";
	}

	@RequestMapping(value="simpleInsertPage.do", method=RequestMethod.GET)
	public String simpleInsertPage() {
		return "simple/simpleInsertPage";
	}

	@RequestMapping(value="simpleInsert.do", method=RequestMethod.GET)
	public String simpleInsert(
			HttpServletRequest request,
			RedirectAttributes rttr,
			Model model) {
		model.addAttribute("request", request);
		model.addAttribute("rttr", rttr);
		simpleInsertCommand.execute(sqlSession, model);
		// model에 저장된 insertResult는 request에 저장되어 있습니다.
		// return "redirect:simpleList.do"; 를 통해서 이동할 때는 request가 전달되지 않기 떄문에
		// simpleList.do로 이동되는 jsp페이지인 simple/simpleListPage.jsp에 insertResult는 전달되지 않습니다.
		
		// rttr에 저장된 insertResult는 이동할 jsp에 잘 전달됩니다.
		// rttr에 저장된 값도 JSP는 EL로 처리하면 됩니다. (${insertResult})
		return "redirect:simpleList.do";
	}

	@RequestMapping(value="simpleViewPage.do", method=RequestMethod.GET)
	public String simpleViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleViewCommand.execute(sqlSession, model);
		return "simple/simpleViewPage";
	}

	@RequestMapping(value="simpleUpdatePage.do", method=RequestMethod.POST)
	public String simpleUpdatePage(
			@ModelAttribute("simpleDto") SimpleDto simpleDto,
			@ModelAttribute("page") int page) {
		return "simple/simpleUpdatePage";
	}
	
	@RequestMapping(value="simpleUpdate.do", method=RequestMethod.POST)
	public String simpleUpdate(
			@ModelAttribute("simpleDto") SimpleDto simpleDto,
			@RequestParam("page") String page,
			RedirectAttributes rttr,
			Model model) {
		model.addAttribute("rttr", rttr);
		simpleUpdateCommand.execute(sqlSession, model);
		return "redirect:simpleViewPage.do?no=" + simpleDto.getNo() + "&page=" + page;
	}
	
	@RequestMapping(value="simpleDelete.do", method=RequestMethod.POST)
	public String simpleDelete(
			@ModelAttribute("no") int no,
			RedirectAttributes rttr,
			Model model) {
		model.addAttribute("rttr", rttr);
		simpleDeleteCommand.execute(sqlSession, model);
		model.asMap().clear();
		return "redirect:simpleList.do";
	}
}
