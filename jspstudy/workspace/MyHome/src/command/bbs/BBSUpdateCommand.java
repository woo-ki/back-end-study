package command.bbs;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.BBSDao;
import dto.BBSDto;

public class BBSUpdateCommand implements BBSCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		String bbs_title = request.getParameter("bbs_title");
		String bbs_content = request.getParameter("bbs_content");
		int bbs_no = 0;
		if(request.getParameter("bbs_no") != null && !request.getParameter("bbs_no").isEmpty()) {
			bbs_no = Integer.parseInt(request.getParameter("bbs_no"));
		}
		
		BBSDto bbsDto = new BBSDto();
		bbsDto.setBbs_title(bbs_title);
		bbsDto.setBbs_content(bbs_content);
		bbsDto.setBbs_no(bbs_no);
		
		int result = BBSDao.getInstance().bbsUpdate(bbsDto);

		PathNRedirect pathNRedirect = null;
		if(result > 0) {
			pathNRedirect = new PathNRedirect();
			pathNRedirect.setPath("/MyHome/bbsViewPage.bbs?bbs_no=" + bbs_no + "&page=" + page);
			pathNRedirect.setRedirect(true);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("<alert('게시글 수정에 실패하였습니다.')>");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return pathNRedirect;
	}

}
