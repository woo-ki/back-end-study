package com.koreait.contact2.command;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(ContactDao contactDao, Model model) {
		contactDao = new ContactDao();
		model.addAttribute("list", contactDao.contactList());
	}
}
