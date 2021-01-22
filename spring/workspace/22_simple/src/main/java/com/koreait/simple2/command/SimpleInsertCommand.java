package com.koreait.simple2.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.simple2.dao.SimpleDao;
import com.koreait.simple2.dto.SimpleDto;

public class SimpleInsertCommand implements SimpleCommand {
	@Autowired
	private SimpleDao simpleDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		SimpleDto simpleDto = (SimpleDto) map.get("simpleDto");
		simpleDao.simpleInsert(simpleDto);
	}

}
