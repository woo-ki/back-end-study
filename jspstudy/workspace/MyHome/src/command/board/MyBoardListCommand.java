package command.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import common.PathNRedirect;
import dao.BoardDao;
import dto.BoardDto;

public class MyBoardListCommand implements BoardCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mId = request.getParameter("mId");
		
		String strPage = request.getParameter("page");
		int page = 1;
		if (strPage != null && !strPage.isEmpty()) {
			page = Integer.parseInt(strPage);
		}
		
		int totalMyRecord = BoardDao.getInstance().getTotalMyRecord(mId);
		
		int recordPerPage = 5;
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		endRecord = endRecord < totalMyRecord ? endRecord : totalMyRecord;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("beginRecord", beginRecord + "");
		map.put("endRecord", endRecord + "");
		
		List<BoardDto> list = BoardDao.getInstance().myBoardList(map);
		
		String path = "myBoardListPage.board?mId=" + mId;
		String paging = Paging.getPaging(path, totalMyRecord, recordPerPage, page);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("totalRecord", totalMyRecord);
		request.setAttribute("page", page);
		request.setAttribute("recordPerPage", recordPerPage);
		
		// boardListPage.jsp로 포워드한다.
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("board/boardListPage.jsp");
		pathNRedirect.setRedirect(false);
		
		return pathNRedirect;
	}

}
