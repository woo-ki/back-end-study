package com.koreait.contact3.command;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.contact3.config.AppContext;
import com.koreait.contact3.dao.ContactDao;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(AbstractApplicationContext ctx, Model model) {
		ctx = new AnnotationConfigApplicationContext(AppContext.class);
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		ctx.close();
		model.addAttribute("list", contactDao.contactList());
	}

}
