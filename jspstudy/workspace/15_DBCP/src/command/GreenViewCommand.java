package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.GreenDao;
import dto.GreenDto;

public class GreenViewCommand implements GreenCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo != null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		
		GreenDao.getInstance().updateHit(no);
		GreenDto greenDto = GreenDao.getInstance().view(no);
		boolean result = false;
		if(greenDto != null) {
			result = true;
		}
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		if(result) {	// 성공
			request.setAttribute("greenDto", greenDto);
			pathNRedirect.setPath("green/viewPage.jsp");
			pathNRedirect.setRedirect(false);
		} else {	// 실패
			pathNRedirect.setPath("green/viewFail.jsp");
			pathNRedirect.setRedirect(false);
		}
		return pathNRedirect;
	}

}
