package com.koreait.contact3.command;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.contact3.config.AppContext;
import com.koreait.contact3.dao.ContactDao;

public class ContactDeleteCommand implements ContactCommand {

	@Override
	public void execute(AbstractApplicationContext ctx, Model model) {
		ctx = new AnnotationConfigApplicationContext(AppContext.class);
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		ctx.close();
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		contactDao.contactDelete(no);
	}

}
