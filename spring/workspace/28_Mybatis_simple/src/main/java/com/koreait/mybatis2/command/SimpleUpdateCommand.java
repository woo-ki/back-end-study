package com.koreait.mybatis2.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.dao.SimpleDao;
import com.koreait.mybatis2.dto.SimpleDto;

public class SimpleUpdateCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);
		SimpleDto simpleDto = (SimpleDto) map.get("simpleDto");
		RedirectAttributes rttr = (RedirectAttributes) map.get("rttr");
		
		try {
			int updateResult = simpleDao.simpleUpdate(simpleDto);
			rttr.addFlashAttribute("updateResult", updateResult);
		} catch (Exception e) {
			rttr.addFlashAttribute("updateResult", 0);
		}
	}

}
