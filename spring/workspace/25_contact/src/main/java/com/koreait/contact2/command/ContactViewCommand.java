package com.koreait.contact2.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(ContactDao contactDao, Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		contactDao = new ContactDao();
		model.addAttribute("contactDto", contactDao.contactView(no));
	}
}
