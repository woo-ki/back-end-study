package com.koreait.simple3.command;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.simple3.dao.SimpleDao;
import com.koreait.simple3.dto.SimpleDto;

public class SimpleUpdateCommand implements SimpleCommand {

	@Override
	public void execute(AbstractApplicationContext ctx, Model model) {
		SimpleDao simpleDao = ctx.getBean("simpleDao", SimpleDao.class);
		Map<String, Object> map = model.asMap();
		SimpleDto simpleDto = (SimpleDto) map.get("simpleDto");
		simpleDao.simpleUpdate(simpleDto);
	}

}
