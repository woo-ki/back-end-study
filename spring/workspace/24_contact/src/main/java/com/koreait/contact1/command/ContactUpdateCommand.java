package com.koreait.contact1.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact1.dao.ContactDao;
import com.koreait.contact1.dto.ContactDto;

public class ContactUpdateCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		ContactDto contactDto = (ContactDto) map.get("contactDto");
		ContactDao contactDao = new ContactDao();
		contactDao.contactUpdate(contactDto);
	}

}
