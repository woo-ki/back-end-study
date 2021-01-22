package com.koreait.contact1.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact1.dao.ContactDao;
import com.koreait.contact1.dto.ContactDto;

public class ContactInsertCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		ContactDto contactDto = (ContactDto) map.get("contactDto");
		String name = contactDto.getName();
		String phone = contactDto.getPhone();
		String address = contactDto.getAddress();
		String email = contactDto.getEmail();
		String note = contactDto.getNote();
		ContactDao contactDao = new ContactDao();
		// contactDao.contactInsert1(contactDto);
		// contactDao.contactInsert2(name, phone, address, email, note);;
		contactDao.contactInsert3(name, phone, address, email, note);
	}

}
