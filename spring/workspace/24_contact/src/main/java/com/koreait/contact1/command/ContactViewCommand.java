package com.koreait.contact1.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact1.dao.ContactDao;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		ContactDao contactDao = new ContactDao();
		model.addAttribute("contactDto", contactDao.contactView(no));
	}

}
