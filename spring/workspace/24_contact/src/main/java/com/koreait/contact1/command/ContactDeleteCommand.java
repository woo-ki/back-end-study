package com.koreait.contact1.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact1.dao.ContactDao;

public class ContactDeleteCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		ContactDao contactDao = new ContactDao();
		contactDao.contactDelete(no);
	}

}
