package com.koreait.contact1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact1.command.ContactCommand;
import com.koreait.contact1.command.ContactDeleteCommand;
import com.koreait.contact1.command.ContactInsertCommand;
import com.koreait.contact1.command.ContactListCommand;
import com.koreait.contact1.command.ContactUpdateCommand;
import com.koreait.contact1.command.ContactViewCommand;
import com.koreait.contact1.common.SpringJdbc;
import com.koreait.contact1.dto.ContactDto;

@Controller
public class ContactController {

	@Autowired
	public void setTemplate(JdbcTemplate template) { // @Autowired로 injection된 매개변수 JdbcTemplate template 를
		SpringJdbc.template = template;	// 다른 곳에서도 사용할 수 있도록 넘겨 줍니다.
	}
	
	// ContactCommand 인터페이스 선언해 둡니다.
	private ContactCommand command;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String list(Model model) {
		command = new ContactListCommand();
		command.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String insertPage() {
		return "contact/contactInsertPage";
	}
	
	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		command = new ContactInsertCommand();
		command.execute(model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}

	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String viewPage(@ModelAttribute("no") int no, Model model) {
		command = new ContactViewCommand();
		command.execute(model);
		return "contact/contactViewPage";
	}

	@RequestMapping(value="contactUpdate.do", method=RequestMethod.POST)
	public String update(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		command = new ContactUpdateCommand();
		command.execute(model);
		model.asMap().clear();
		return "redirect:contactViewPage.do?no=" + contactDto.getNo();
	}

	@RequestMapping(value="contactDelete.do", method=RequestMethod.POST)
	public String delete(@ModelAttribute("no") int no, Model model) {
		command = new ContactDeleteCommand();
		command.execute(model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}
}
