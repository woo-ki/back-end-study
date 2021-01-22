package com.koreait.simple1.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.simple1.dao.SimpleDao;
import com.koreait.simple1.dto.SimpleDto;

public class SimpleUpdateCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		SimpleDto simpleDto = (SimpleDto) map.get("simpleDto");
		
		SimpleDao.getInstance().simpleUpdate(simpleDto);
	}

}
