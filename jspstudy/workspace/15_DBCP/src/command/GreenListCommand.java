package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.GreenDao;
import dto.GreenDto;

public class GreenListCommand implements GreenCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<GreenDto> list = GreenDao.getInstance().list();
		request.setAttribute("list", list);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("green/listPage.jsp");
		pathNRedirect.setRedirect(false);
		
		return pathNRedirect;
	}

}
