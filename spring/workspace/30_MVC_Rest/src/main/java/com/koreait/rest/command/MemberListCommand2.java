package com.koreait.rest.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.rest.common.Paging;
import com.koreait.rest.dao.MemberDao;
import com.koreait.rest.dto.MemberDto;

public class MemberListCommand2 implements MemberCommand {
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		Map<String, Object> map = model.asMap();
		int totalRecord = memberDao.totalRecord();
		int recordPerPage = 5;
		int page = (int) map.get("page");
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		endRecord = endRecord > totalRecord ? totalRecord : endRecord;
	
		String paging = Paging.getPaging("memberPaging", totalRecord, recordPerPage, page);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<MemberDto> list = memberDao.memberList2(beginRecord, endRecord);
		if(list.size() > 0) {
			resultMap.put("list", list);
			resultMap.put("result", true);
			resultMap.put("paging", paging);
			resultMap.put("totalRecord", totalRecord);
			resultMap.put("page", page);
			resultMap.put("recordPerPage", recordPerPage);
		} else {
			resultMap.put("result", false);
		}
		return resultMap;
	}
}
