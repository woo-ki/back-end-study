package com.koreait.mybatis2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.common.Paging;
import com.koreait.mybatis2.dao.SimpleDao;

public class SimpleListCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int page = 1;
		String strPage = request.getParameter("page");
		if(strPage != null && !strPage.isEmpty()) {
			page = Integer.parseInt(strPage);
		}
		
		int totalRecord = simpleDao.totalRecord();
		// SimpleList는 한 페이지에 몇 개의 레코드를 표시할 것인지 여기서 결정합니다.
		int recordPerPage = 5;
		int beginRecord = (page - 1) * recordPerPage + 1;	// 항상 같음.
		int endRecord = beginRecord + recordPerPage - 1;	// 항상 같음.
		endRecord = endRecord > totalRecord ? totalRecord : endRecord;
		// beginRecord + endRecord 를 list를 가져오는 simpleList()에 전달합니다.
		model.addAttribute("list", simpleDao.simpleList(beginRecord, endRecord));
		
		// Paging을 만듭니다. (이전 1 2 3 4 5 다음)
		// 아래 paging의 path는 List마다 다릅니다.
		// SimpleListCommand	: simpleListPage.do
		// BoardListCommand		: boardListPage.do
		// 검색결과의 페이징	: boardListPage.do?검색결과
		String paging = Paging.getPaging("simpleList.do", totalRecord, recordPerPage, page);
		model.addAttribute("paging", paging);
		model.addAttribute("page", page);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("recordPerPage", recordPerPage);
	}

}
