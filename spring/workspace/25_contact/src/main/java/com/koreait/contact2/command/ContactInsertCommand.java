package com.koreait.contact2.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;
import com.koreait.contact2.dto.ContactDto;

public class ContactInsertCommand implements ContactCommand {

	@Override
	public void execute(ContactDao contactDao, Model model) {
		Map<String, Object> map = model.asMap();
		ContactDto contactDto = (ContactDto) map.get("contactDto");
		contactDao = new ContactDao();
		contactDao.contactInsert(contactDto);
	}
}
