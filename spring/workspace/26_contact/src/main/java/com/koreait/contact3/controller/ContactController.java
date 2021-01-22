package com.koreait.contact3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact3.command.ContactDeleteCommand;
import com.koreait.contact3.command.ContactInsertCommand;
import com.koreait.contact3.command.ContactListCommand;
import com.koreait.contact3.command.ContactUpdateCommand;
import com.koreait.contact3.command.ContactViewCommand;
import com.koreait.contact3.common.SpringJdbc;
import com.koreait.contact3.config.AppContext;
import com.koreait.contact3.dto.ContactDto;

@Controller
public class ContactController {
	@Autowired
	public void setAll(JdbcTemplate template) {
		SpringJdbc.template = template;
	}
	
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	private ContactDeleteCommand contactDeleteCommand = ctx.getBean("contactDeleteCommand", ContactDeleteCommand.class);
	private ContactInsertCommand contactInsertCommand = ctx.getBean("contactInsertCommand", ContactInsertCommand.class);
	private ContactUpdateCommand contactUpdateCommand = ctx.getBean("contactUpdateCommand", ContactUpdateCommand.class);
	private ContactListCommand contactListCommand = ctx.getBean("contactListCommand", ContactListCommand.class);
	private ContactViewCommand contactViewCommand = ctx.getBean("contactViewCommand", ContactViewCommand.class);

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String contactListPage(Model model) {
		contactListCommand.execute(ctx, model);
		return "contact/contactListPage";
	}

	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String contactInsertPage() {
		return "contact/contactInsertPage";
	}

	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String contactInsert(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		contactInsertCommand.execute(ctx, model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}

	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String contactViewPage(@ModelAttribute("no") int no, Model model) {
		contactViewCommand.execute(ctx, model);
		return "contact/contactViewPage";
	}
	
	@RequestMapping(value="contactUpdate.do", method=RequestMethod.POST)
	public String contactUpdate(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		contactUpdateCommand.execute(ctx, model);
		model.asMap().clear();
		return "redirect:contactViewPage.do?no=" + contactDto.getNo();
	}
	
	@RequestMapping(value="contactDelete.do", method=RequestMethod.POST)
	public String contactDelete(@ModelAttribute("no") int no, Model model) {
		contactDeleteCommand.execute(ctx, model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}
}
