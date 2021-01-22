package command.guest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.GuestDao;
import dto.GuestDto;

public class GuestViewCommand2 implements GuestCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strgNo = request.getParameter("gNo");
		int gNo = 0;
		
		if(strgNo != null && strgNo != "") {
			gNo = Integer.parseInt(strgNo);
		}
		
		// guestViewResult.jsp를 사용하지 않는 법
		GuestDto guestDto = GuestDao.getInstance().selectBygNo(gNo);
		
		request.setAttribute("guestDto", guestDto);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		if(guestDto != null) {
			pathNRedirect.setPath("guest/guestViewPage.jsp");
			pathNRedirect.setRedirect(false);
		} else {
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('방명록을 열 수 없습니다. 다시 시도하세요.'");
				out.println("location.href = '/MyHome/guestListPage.guest'");
				out.println("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pathNRedirect;
	}

}
