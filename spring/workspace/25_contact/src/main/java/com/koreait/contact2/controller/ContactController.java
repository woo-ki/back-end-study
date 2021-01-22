package com.koreait.contact2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact2.command.ContactDeleteCommand;
import com.koreait.contact2.command.ContactInsertCommand;
import com.koreait.contact2.command.ContactListCommand;
import com.koreait.contact2.command.ContactUpdateCommand;
import com.koreait.contact2.command.ContactViewCommand;
import com.koreait.contact2.common.SpringJdbc;
import com.koreait.contact2.dao.ContactDao;
import com.koreait.contact2.dto.ContactDto;

@Controller
public class ContactController {
	private ContactListCommand contactListCommand;
	private ContactInsertCommand contactInsertCommand;
	private ContactViewCommand contactViewCommand;
	private ContactUpdateCommand contactUpdateCommand;
	private ContactDeleteCommand contactDeleteCommand;
	private ContactDao contactDao;

	@Autowired
	public void setAll(
			JdbcTemplate template,
			ContactDao contactDao,
			ContactListCommand contactListCommand,
			ContactInsertCommand contactInsertCommand,
			ContactViewCommand contactViewCommand,
			ContactUpdateCommand contactUpdateCommand,
			ContactDeleteCommand contactDeleteCommand) {
		SpringJdbc.template = template;
		this.contactDao = contactDao;
		this.contactListCommand = contactListCommand;
		this.contactInsertCommand = contactInsertCommand;
		this.contactViewCommand = contactViewCommand;
		this.contactUpdateCommand = contactUpdateCommand;
		this.contactDeleteCommand = contactDeleteCommand;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String contactListPage(Model model) {
		contactListCommand.execute(contactDao, model);
		return "contact/contactListPage";
	}

	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String contactInsertPage() {
		return "contact/contactInsertPage";
	}

	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String contactInsert(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		contactInsertCommand.execute(contactDao, model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}

	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String contactViewPage(@ModelAttribute("no") int no, Model model) {
		contactViewCommand.execute(contactDao, model);
		return "contact/contactViewPage";
	}
	
	@RequestMapping(value="contactUpdate.do", method=RequestMethod.POST)
	public String contactUpdate(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
		contactUpdateCommand.execute(contactDao, model);
		model.asMap().clear();
		return "redirect:contactViewPage.do?no=" + contactDto.getNo();
	}
	
	@RequestMapping(value="contactDelete.do", method=RequestMethod.POST)
	public String contactDelete(@ModelAttribute("no") int no, Model model) {
		contactDeleteCommand.execute(contactDao, model);
		model.asMap().clear();
		return "redirect:contactListPage.do";
	}
}