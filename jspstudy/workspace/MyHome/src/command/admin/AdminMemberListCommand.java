package command.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import common.PathNRedirect;
import dao.AdminDao;
import dto.MemberDto;

public class AdminMemberListCommand implements AdminCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 전체 member의 갯수를 구한다.
		int totalMemberCount = AdminDao.getInstance().getTotalMemberCount();
		
		String strPage = request.getParameter("page");
		int page = 1;
		if(strPage != null && !strPage.isEmpty()) {
			page = Integer.parseInt(strPage);
		}
		
		int recordPerPage = 20;
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		endRecord = endRecord < totalMemberCount ? endRecord : totalMemberCount;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", beginRecord);
		map.put("endRecord", endRecord);

		String path = "/MyHome/adminMemberListPage.admin";
		String paging = Paging.getPaging(path, totalMemberCount, recordPerPage, page);
		
		List<MemberDto> list = AdminDao.getInstance().adminMemberList(map);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("totalMemeberCount", totalMemberCount);
		request.setAttribute("recordPerPage", recordPerPage);
		request.setAttribute("paging", paging);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("admin/adminMemberListPage.jsp");
		pathNRedirect.setRedirect(false);
		return pathNRedirect;
	}

}
