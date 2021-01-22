package com.koreait.mybatis2.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.dao.SimpleDao;

public class SimpleDeleteCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		RedirectAttributes rttr = (RedirectAttributes) map.get("rttr");
		SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);
		
		try {
			int deleteResult = simpleDao.simpleDelete(no);
			rttr.addFlashAttribute("deleteResult", deleteResult);
		} catch (Exception e) {
			rttr.addFlashAttribute("deleteResult", 0);
		}
	}

}
