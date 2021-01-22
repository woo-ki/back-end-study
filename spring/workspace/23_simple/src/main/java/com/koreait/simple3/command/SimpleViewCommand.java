package com.koreait.simple3.command;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.simple3.dao.SimpleDao;

public class SimpleViewCommand implements SimpleCommand {

	@Override
	public void execute(AbstractApplicationContext ctx, Model model) {
		SimpleDao simpleDao = ctx.getBean("simpleDao", SimpleDao.class);
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		model.addAttribute("simpleDto", simpleDao.simpleViewPage(no));
	}

}
