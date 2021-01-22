package com.koreait.simple3.command;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.simple3.dao.SimpleDao;

public class SimpleListCommand implements SimpleCommand {
	
	@Override
	public void execute(AbstractApplicationContext ctx, Model model) {
		SimpleDao simpleDao = ctx.getBean("simpleDao", SimpleDao.class);
		model.addAttribute("list", simpleDao.allList());
	}
}
