package com.koreait.contact2.command;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public interface ContactCommand {
	
	public void execute(ContactDao contactDao, Model model);
}
