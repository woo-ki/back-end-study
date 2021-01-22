package com.koreait.rest.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.rest.dao.MemberDao;

public class MemberDeleteCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int no = (int) map.get("no");
		
		int result = sqlSession.getMapper(MemberDao.class).memberDelete(no);
		if(result > 0) {
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		return resultMap;
	}

}
