package com.koreait.mybatis3.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.BoardDao;

public class BoardViewCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		int no = (int) map.get("no");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		model.addAttribute("boardDto", boardDao.boardView(no));

	}

}
