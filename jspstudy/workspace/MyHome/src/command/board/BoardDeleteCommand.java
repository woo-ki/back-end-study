package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.BoardDao;

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strbNo = request.getParameter("bNo");
		int bNo = 0;
		if (strbNo != null && !strbNo.isEmpty()) {
			bNo = Integer.parseInt(strbNo);
		}
		
		int result = BoardDao.getInstance().boardDelete(bNo);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("board/boardDeleteResult.jsp?result=" + result + "&page=" + request.getParameter("page"));
		pathNRedirect.setRedirect(true);
		return pathNRedirect;
	}

}
