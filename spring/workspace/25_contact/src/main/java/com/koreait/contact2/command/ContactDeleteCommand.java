package com.koreait.contact2.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactDeleteCommand implements ContactCommand {

	@Override
	public void execute(ContactDao contactDao, Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		contactDao = new ContactDao();
		contactDao.contactDelete(no);
	}
}
