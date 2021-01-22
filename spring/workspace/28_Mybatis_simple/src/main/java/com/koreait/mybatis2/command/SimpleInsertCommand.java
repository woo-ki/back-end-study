package com.koreait.mybatis2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.dao.SimpleDao;

public class SimpleInsertCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		RedirectAttributes rttr = (RedirectAttributes) map.get("rttr");
		SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);
		
		try {
			int insertResult = simpleDao.simpleInsert(writer, title, content);
			
			rttr.addFlashAttribute("insertResult", insertResult);
		} catch (Exception e) {
			rttr.addFlashAttribute("insertResult", 0);
		}
	}

}
