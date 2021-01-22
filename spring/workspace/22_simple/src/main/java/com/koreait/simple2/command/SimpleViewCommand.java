package com.koreait.simple2.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.simple2.dao.SimpleDao;

public class SimpleViewCommand implements SimpleCommand {
	@Autowired
	private SimpleDao simpleDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		model.addAttribute("simpleDto", simpleDao.simpleViewPage(no));
	}

}
